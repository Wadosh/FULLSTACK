
public class ContaPoupanca extends Conta{
	private double txCorrecao;

	
	public ContaPoupanca(Pessoa cliente, int nrConta, Double saldo, double txCorrecao) {
		super(cliente, nrConta, saldo);
		this.txCorrecao = txCorrecao;
	}
	
	
	public double getTxCorrecao() {
		return txCorrecao;
	}
	public void setTxCorrecao(double txCorrecao) {
		this.txCorrecao = txCorrecao;
	}
	
	
	public void atualizaSaldoRendimento(Conta c1) {
		double saldo = c1.getSaldo();
		
		saldo = saldo + (saldo*txCorrecao);
		
		c1.setSaldo(saldo);
	}
	
	
	public ContaPoupanca abrirConta(Pessoa cliente, int nrConta, double saldo, double txCorrecao) {
		ContaPoupanca cp1 = new ContaPoupanca(cliente, nrConta, saldo, txCorrecao);
		
		return cp1;
	}
}
