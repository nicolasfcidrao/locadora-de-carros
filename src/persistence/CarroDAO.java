package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carro;

public class CarroDAO {

    private static final String ARQUIVO_DE_TEXTO = "carros.txt";
    private static ArrayList<Carro> carrosAux = new ArrayList<Carro>();

    public void inserirCarro(Carro c) {
        carrosAux.add(c);

        escreverArquivo();
    }

    public Carro buscarCarro(String placa) {
        
        for (Carro carT : carrosAux) {
            if (carT.getPlaca().equals(placa)) {
                return carT;
            }
        }
        return null;
    }
    
    public Carro buscarCarro(Carro c) {
        
        for (Carro carT : carrosAux) {
            if (carT.getPlaca().equals(c.getPlaca())) {
                return carT;
            }
        }
        return null;
    }
    
    public void alterarCarro(Carro c) {
        Carro cT = buscarCarro(c);

        if (cT == null) {
            return;
        }
        
        cT.setModelo(c.getModelo());
        cT.setPortas(c.getPortas());
        cT.setArCondicionado(c.isArCondicionado());
        cT.setAutomatico(c.isAutomatico());
        cT.setTrava(c.isTrava());
        cT.setVidro(c.isVidro());
        cT.setValor(c.getValor());

        escreverArquivo();
    }
    
    public void alugarCarro(String placa) {
        Carro cT = buscarCarro(placa);

        if (cT == null) {
            return;
        }
        
        cT.setDisponibilidade("ALUGADO");

        escreverArquivo();
    }

    public List<Carro> buscarPorPlaca(String placa) {
        List<Carro> carros = new ArrayList();
        for (Carro carT : carrosAux) {
            if (carT.getPlaca().contains(placa)) {
                carros.add(carT);
            }
        }
        return carros;
    }

    public ArrayList<Carro> listarCarro() {
        return carrosAux;
    }

    public void escreverArquivo() {
        File f = new File(ARQUIVO_DE_TEXTO);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (Carro cT : carrosAux) {
                bw.write(cT.getPlaca() + ";" + cT.getCor() + ";" + cT.getPortas() + ";" + cT.isAutomatico() + ";" + cT.getValor() + ";" + cT.getModelo() + ";" + cT.isTrava() + ";" + cT.isArCondicionado() + ";" + cT.isVidro() + ";" + cT.getDisponibilidade());
                bw.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    static {
        File f = new File(ARQUIVO_DE_TEXTO);
        FileReader fr = null;
        BufferedReader br = null;

        try {

            if (!f.exists()) {
                f.createNewFile();
            }

            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String linha;
            while ((linha = br.readLine()) != null) {
                String info[] = linha.split(";");
                Carro c;
                c = new Carro(info[0], info[1], Integer.parseInt(info[2]), Boolean.parseBoolean(info[3]), Double.parseDouble(info[4]), info[5], Boolean.parseBoolean(info[6]), Boolean.parseBoolean(info[7]), Boolean.parseBoolean(info[8]), info[9]);
                carrosAux.add(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
