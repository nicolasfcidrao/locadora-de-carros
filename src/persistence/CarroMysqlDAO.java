package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carro;

public class CarroMysqlDAO {

    public void inserir(Carro c) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("insert into carro values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, c.getPlaca());
            stmt.setInt(2, c.getPortas());
            stmt.setString(3, c.getModelo());
            stmt.setString(4, c.getCor());
            stmt.setString(5, c.getDisponibilidade());
            stmt.setBoolean(6, c.isArCondicionado());
            stmt.setBoolean(7, c.isTrava());
            stmt.setBoolean(8, c.isVidro());
            stmt.setBoolean(9, c.isAutomatico());
            stmt.setDouble(10, c.getValor());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void excluir(String placa) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("delete from carro where placa=?");

            stmt.setString(0, placa);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void alterar(Carro c) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("update carro set  placa=?, portas=?, modelo=?, cor=?, disponibilidade=?, "
                    + "ar_condicionado=?, trava=?, vidro=?, automatico=?, valor=? where placa=?");

            stmt.setString(1, c.getPlaca());
            stmt.setInt(2, c.getPortas());
            stmt.setString(3, c.getModelo());
            stmt.setString(4, c.getCor());
            stmt.setString(5, c.getDisponibilidade());
            stmt.setBoolean(6, c.isArCondicionado());
            stmt.setBoolean(7, c.isTrava());
            stmt.setBoolean(8, c.isVidro());
            stmt.setBoolean(9, c.isAutomatico());
            stmt.setDouble(10, c.getValor());
            stmt.setString(11, c.getPlaca());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public List<Carro> listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<Carro> cTemp = new ArrayList<>();

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("select * from carro");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String pl = rs.getString("placa");
                int pt = rs.getInt("portas");
                String md = rs.getString("modelo");
                String cor = rs.getString("cor");
                String dsp = rs.getString("disponibilidade");
                Boolean ar = rs.getBoolean("ar_condicionado");
                Boolean tr = rs.getBoolean("trava");
                Boolean vd = rs.getBoolean("vidro");
                Boolean at = rs.getBoolean("automatico");
                double vlr = rs.getDouble("valor");

                Carro c = new Carro(pl, cor, pt, at, vlr, md, tr, ar, vd, dsp);
                cTemp.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return cTemp;
    }

    public Carro buscar(String placa) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("select * from carro where placa=?");

            stmt.setString(1, placa);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                String pl = rs.getString("placa");
                int pt = rs.getInt("portas");
                String md = rs.getString("modelo");
                String cor = rs.getString("cor");
                String dsp = rs.getString("disponibilidade");
                Boolean ar = rs.getBoolean("ar_condicionado");
                Boolean tr = rs.getBoolean("trava");
                Boolean vd = rs.getBoolean("vidro");
                Boolean at = rs.getBoolean("automatico");
                double vlr = rs.getDouble("valor");

                Carro c = new Carro(pl, cor, pt, at, vlr, md, tr, ar, vd, dsp);
                return c;

            }
        } catch (SQLException ex) {
            Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return null;
    }

    public void alugar(String placa) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("update carro set disponibilidade=? where placa=?");

            stmt.setString(1, "ALUGADO");
            stmt.setString(2, placa);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CarroMysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
