
public class Conta {
	private Pessoa cliente;
	private int nrConta;
	private Double saldo;
	
	
	public Conta(Pessoa cliente, int nrConta, Double saldo) {
		super();
		this.cliente = cliente;
		this.nrConta = nrConta;
		this.saldo = saldo;
	}
	
	
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	
	public int getNrConta() {
		return nrConta;
	}
	public void setNrConta(int nrConta) {
		this.nrConta = nrConta;
	}
	
	
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
	public Conta abrirConta(Pessoa cliente, int nrConta, double saldo) {
		Conta c1 = new Conta(cliente, nrConta, saldo);
		return c1;
	}
	
	
	public void sacar(double valor) {
		if(temSaldo(valor)) {
			debitar(valor);
			System.out.println("SAQUE REALIZADO COM SUCESSO");
		}
		else
			System.out.println("SALDO INDISPONIVEL PARA REALIZAR O SAQUE");
	}
	
	
	private void debitar(double valor) {
		saldo = saldo - valor;
	}
	
	
	protected boolean temSaldo(double valor) {
		if(saldo - valor >= 0)
			return true;
		else
			return false;
	}
	
	
	public void depositar(double valor) {
		saldo = saldo + valor;
	}
	
	public void transferir(double valor, Conta cDestino) {
		if(temSaldo(valor)) {
			debitar(valor);
			cDestino.depositar(valor);
			System.out.println("TRASNFERENCIA REALIZADA COM SUCESSO");
		}
		else
			System.out.println("SALDO INDISPONIVEL PARA REALIZAR A TRANSFERENCIA");
	}
}