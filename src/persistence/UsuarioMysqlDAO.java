package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

public class UsuarioMysqlDAO {

    public void inserir(Usuario u) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("insert into usuario values (?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, u.getCpf());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setLong(4, u.getTelefone());
            stmt.setInt(5, u.getIdade());
            stmt.setBoolean(6, u.getHabilitado());
            stmt.setString(7, u.getSenha());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void excluir(String cpf) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("delete from usuario where cpf=?");

            stmt.setString(1, cpf);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void alterar(Usuario u) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();

            stmt = con.prepareStatement("update usuario set cpf =?, nome=?, email=?, senha=?, telefone=?, idade=?, habilitado=? where cpf=?");

            stmt.setString(1, u.getCpf());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSenha());
            stmt.setLong(5, u.getTelefone());
            stmt.setInt(6, u.getIdade());
            stmt.setBoolean(7, u.getHabilitado());
            stmt.setString(8, u.getCpf());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public List<Usuario> listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<Usuario> uTemp = new ArrayList<>();

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("select * from usuario");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                int idade = rs.getInt("idade");
                long telefone = rs.getLong("telefone");
                boolean habilitado = rs.getBoolean("habilitado");
                String senha = rs.getString("senha");

                Usuario usu = new Usuario(nome, cpf, email, senha, idade, telefone, habilitado);
                uTemp.add(usu);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return uTemp;
    }

    public Usuario buscar(String cpf) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("select * from usuario where cpf=?");

            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                long telefone = rs.getLong("telefone");
                int idade = rs.getInt("idade");
                boolean habilitado = rs.getBoolean("habilitado");
                String senha = rs.getString("senha");

                Usuario u = new Usuario(nome, cpf, email, senha, idade, telefone, habilitado);
                return u;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    public Usuario logar(String email) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("select * from usuario where email=?");

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                long telefone = rs.getLong("telefone");
                int idade = rs.getInt("idade");
                boolean habilitado = rs.getBoolean("habilitado");
                String senha = rs.getString("senha");

                Usuario u = new Usuario(nome, cpf, email, senha, idade, telefone, habilitado);
                return u;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }
}
