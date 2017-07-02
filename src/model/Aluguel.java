package model;

import java.util.Calendar;
import java.util.Date;
import persistence.CarroDAO;
import util.DataUtil;

public class Aluguel {
	private String cpfCliente;
	private Date DataRetirada;
	private Date DataDevolver;
	private String formaPagamento;
	private String placaCarro;

	public Aluguel(String cpfCliente, Date dataRetirada, Date dataDevolver, String formaPagamento,
			String placaCarro) {
		this.cpfCliente = cpfCliente;
		DataRetirada = dataRetirada;
		DataDevolver = dataDevolver;
		this.formaPagamento = formaPagamento;
		this.placaCarro = placaCarro;
	}
        
        public double calcularValorAluguel() {
            CarroDAO carroDao = new CarroDAO();
            Carro carro = carroDao.buscarCarro(placaCarro);
            
            int qtdeDias = DataUtil.getQtdeDias(DataRetirada, DataDevolver);
            
            return carro.getValor() * qtdeDias;
        }

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Date getDataRetirada() {
		return DataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		DataRetirada = dataRetirada;
	}

	public Date getDataDevolver() {
		return DataDevolver;
	}

	public void setDataDevolver(Date dataDevolver) {
		DataDevolver = dataDevolver;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}
