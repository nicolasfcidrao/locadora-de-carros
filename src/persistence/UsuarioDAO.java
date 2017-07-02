package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

public class UsuarioDAO {

    private static final String ARQUIVO_DE_TEXTO = "usuario.txt";
    private static ArrayList<Usuario> usuariosAux = new ArrayList<Usuario>();

    public void inserirUsuario(Usuario u) {
        usuariosAux.add(u);

        escreverArquivo();
    }

    public void removerUsuario(String cpf) {
        Usuario usuT = buscarPorCpf(cpf);
        usuariosAux.remove(usuT);

        escreverArquivo();
    }

    public void alterarUsuario(Usuario u) {
        Usuario usuT = buscarPorCpf(u.getCpf());

        usuT.setNome(u.getNome());
        usuT.setEmail(u.getEmail());
        usuT.setSenha(u.getSenha());
        usuT.setIdade(u.getIdade());
        usuT.setTelefone(u.getTelefone());

        escreverArquivo();
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario usuT : usuariosAux) {
            if (usuT.getEmail().equals(email)) {
                return usuT;
            }
        }
        return null;
    }

    public Usuario buscarPorCpf(String cpf) {
        for (Usuario usuT : usuariosAux) {
            if (usuT.getCpf().equals(cpf)) {
                return usuT;
            }
        }
        return null;
    }

    public ArrayList<Usuario> listarUsuario() {
        return usuariosAux;
    }

    private void escreverArquivo() {
        File f = new File(ARQUIVO_DE_TEXTO);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (Usuario usuT : usuariosAux) {
                bw.write(usuT.getNome() + ";" + usuT.getCpf() + ";" + usuT.getEmail() + ";" + usuT.getSenha() + ";" + usuT.getIdade() + ";" + usuT.getTelefone() + ";" + usuT.getHabilitado());
                bw.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Usuario u = new Usuario(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]), Long.parseLong(info[5]), Boolean.parseBoolean(info[6]));
                usuariosAux.add(u);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
