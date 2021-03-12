
public class ContaEspecial extends Conta{
	private double limite;
	
	
	public ContaEspecial(Pessoa cliente, int nrConta, Double saldo, double limite) {
		super(cliente, nrConta, saldo);
		this.limite = limite;
	}
	
	
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	
	protected boolean temSaldo(double valor) {
		double saldo = getSaldo();
		
		if(saldo + limite - valor > 0)
			return true;
		else
			return false;
	}
	
	
	public ContaEspecial abrirConta(Pessoa cliente, int nrConta, double saldo, double limite) {
		ContaEspecial ce1 = new ContaEspecial(cliente, nrConta, saldo, limite);
		
		return ce1;
	}
}
