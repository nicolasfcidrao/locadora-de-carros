package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluguel;
import model.Usuario;
import util.DataUtil;

public class AluguelDAO {

    private static final String ARQUIVO_DE_TEXTO = "aluguel.txt";
    private static ArrayList<Aluguel> aluguelAux = new ArrayList<Aluguel>();

    public void inserirAluguel(Aluguel a) {
        aluguelAux.add(a);

        escreverArquivo();
    }

    public Aluguel buscarAluguelPorCpf(String cpf) {
        for (Aluguel aT : aluguelAux) {
            if (aT.getCpfCliente().equals(cpf)) {
                return aT;
            }
        }

        return null;
    }

    public void alterarAluguel(Aluguel a) {
        Aluguel aT = buscarAluguelPorCpf(a.getCpfCliente());

        aT.setCpfCliente(a.getCpfCliente());
        aT.setDataDevolver(a.getDataDevolver());
        aT.setDataRetirada(a.getDataRetirada());
        aT.setFormaPagamento(a.getFormaPagamento());
        aT.setPlacaCarro(a.getPlacaCarro());

        escreverArquivo();
    }

    public Aluguel buscarCarro(String placa) {
        for (Aluguel aT : aluguelAux) {
            if (aT.getPlacaCarro().equals(placa)) {
                return aT;
            }
        }

        return null;
    }

    public ArrayList<Aluguel> listarAluguel() {
        return aluguelAux;
    }

    public void escreverArquivo() {
        File f = new File(ARQUIVO_DE_TEXTO);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (Aluguel aT : aluguelAux) {
                bw.write(aT.getCpfCliente() + ";" + DataUtil.dateToString(aT.getDataRetirada()) + ";" + DataUtil.dateToString(aT.getDataDevolver()) + ";" + aT.getFormaPagamento() + ";" + aT.getPlacaCarro());
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
                Aluguel a;
                a = new Aluguel(info[0], DataUtil.stringToDate(info[1]), DataUtil.stringToDate(info[2]), info[3], info[4]);
                aluguelAux.add(a);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
