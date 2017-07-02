package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluguel;

public class AluguelMySqlDAO {

    public void inserir(Aluguel a) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("insert into aluguel (data_retirada, "
                    + "data_devolver,"
                    + "forma_pagamento,"
                    + "usuario_cpf,"
                    + "carro_placa) values (?, ?, ?, ?, ?)");

            stmt.setTimestamp(1, new Timestamp(a.getDataRetirada().getTime()));
            stmt.setTimestamp(2, new Timestamp(a.getDataDevolver().getTime()));
            stmt.setString(3, a.getFormaPagamento());
            stmt.setString(4, a.getCpfCliente());
            stmt.setString(5, a.getPlacaCarro());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AluguelMySqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AluguelMySqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void alterar(Aluguel a) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("update aluguel set data_retirada=?, data_devolver=?, forma_pagamento=? where carro_placa=? ");
            stmt.setTimestamp(1, new Timestamp(a.getDataRetirada().getTime()));
            stmt.setTimestamp(2, new Timestamp(a.getDataDevolver().getTime()));
            stmt.setString(3, a.getFormaPagamento());
            stmt.setString(4, a.getPlacaCarro());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AluguelMySqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AluguelMySqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public List<Aluguel> listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<Aluguel> aTemp = new ArrayList<>();

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("select * from aluguel");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Date dRetirada = rs.getDate("data_retirada");
                Date dDevolver = rs.getDate("data_devolver");
                String frPgto = rs.getString("forma_pagamento");
                String uCpf = rs.getString("usuario_cpf");
                String pCar = rs.getString("placa_carro");

                Aluguel a = new Aluguel(uCpf, dRetirada, dDevolver, frPgto, pCar);
                aTemp.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AluguelMySqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aTemp;
    }

    public Aluguel buscarPorCpf(String cpf) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("select * from aluguel where usuario_cpf = ?");

            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Date dRetirada = rs.getDate("data_retirada");
                Date dDevolver = rs.getDate("data_devolver");
                String frPgto = rs.getString("forma_pagamento");
                String uCpf = rs.getString("usuario_cpf");
                String pCar = rs.getString("carro_placa");

                Aluguel a = new Aluguel(uCpf, dRetirada, dDevolver, frPgto, pCar);
                return a;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AluguelMySqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
