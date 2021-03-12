import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main (String[] args) {
		
		
		// Criacao de pessoa fisica com conta especial
		Calendar idadeJorge = Calendar.getInstance();
        idadeJorge.set(2001, 4, 23);
        PessoaFisica Jorge = new PessoaFisica(1, "Jorge", "Anapolis", 111, idadeJorge, "masculino");
        ContaEspecial ContaJorge = new ContaEspecial(Jorge, 1, 500.00, 2000.00);
        
        
        // Criacao de pessoa fisica com conta poupanca
        Calendar idadeLuciana = Calendar.getInstance();
        idadeLuciana.set(2003, 1, 12);
        PessoaFisica Luciana = new PessoaFisica(2, "Luciana", "Rio Verde", 222, idadeLuciana, "feminino");
      	ContaPoupanca ContaLuciana = new ContaPoupanca(Luciana, 2, 10.00, 0.05);

		
      	// Criacao de pessoa juridica com conta especial
		PessoaJuridica CocaCola = new PessoaJuridica(3, "CocaCola", "EUA", 333, "alimenticia");
		ContaEspecial ContaCocaCola = new ContaEspecial(CocaCola, 3, 10000.00, 5000000.00);
		
		
		// Criacao de pessoa juridica com conta pouoanca
		PessoaJuridica Mappa = new PessoaJuridica(4, "Mappa", "Jopão", 444, "entreterimento");
		ContaPoupanca ContaMappa = new ContaPoupanca(Mappa, 4, 1000.00, 0.15);
		
		System.out.println("---------------------------------");
		// Teste de idade das pessoas fisicas criadas
		System.out.println("Idade do Jorge:");
		System.out.println(Jorge.getIdade());
		System.out.println("Idade da luciana:");
        System.out.println(Luciana.getIdade());
		
        System.out.println("---------------------------------");
        // Teste do saldo (e limite se houver) de cada um na criacao da conta
        System.out.println("Saldo e limite do jorge ao criar a conta:");
        System.out.println(ContaJorge.getSaldo());
        System.out.println(ContaJorge.getLimite());
        
        System.out.println("Saldo da Luciana ao criar a conta:");
        System.out.println(ContaLuciana.getSaldo());
        
        System.out.println("Saldo e limite da Coca Cola ao criar a conta:");
        System.out.println(ContaCocaCola.getSaldo());
        System.out.println(ContaCocaCola.getLimite());
        
        System.out.println("Saldo da Mappa ao criar a conta:");
        System.out.println(ContaMappa.getSaldo());
        System.out.println("---------------------------------");
        
        // Teste das funcionalidades do banco
        
        // Saque de dinheiro com saldo disponivel
        ContaJorge.sacar(700.0);
        
        System.out.println("Saldo do jorge apos saque de 700 reais:");
        System.out.println(ContaJorge.getSaldo());
        System.out.println("---------------------------------");	
        // Saque sem saldo disponivel
        ContaMappa.sacar(1200.0);
        
        System.out.println("Saldo da Mappa apos saque de 1200 reais:");
        System.out.println(ContaMappa.getSaldo());
        System.out.println("---------------------------------");
        // deposito
        ContaLuciana.depositar(300.0);
        
        System.out.println("Saldo da Luciana apos deposito de 300 reais:");
        System.out.println(ContaLuciana.getSaldo());
        System.out.println("---------------------------------");
        // transferencia com saldo disponivel
        ContaMappa.transferir(500.0, ContaCocaCola);
        
        System.out.println("Saldo da Mappa depois de transferir 500 reais");
        System.out.println(ContaMappa.getSaldo());
        
        System.out.println("Saldo da Coca Cola depois de receber 500 reais:");
        System.out.println(ContaCocaCola.getSaldo());
        System.out.println("---------------------------------");
        
        // transferencia sem saldo disponivel
        ContaLuciana.transferir(1000.0, ContaJorge);
        
        System.out.println("Saldo da Luciana depois de transferir 1000 reais:");
        System.out.println(ContaLuciana.getSaldo());
        
        System.out.println("Saldo do jorge depois de receber 1000 reais:");
        System.out.println(ContaJorge.getSaldo());
        System.out.println("---------------------------------");
        //lista de contas e valor total
        
        List<Conta> listConta = new ArrayList<Conta>();
        listConta.add(ContaJorge);
        listConta.add(ContaLuciana);
        listConta.add(ContaCocaCola);
        listConta.add(ContaMappa);
        
        Double total = 0.0;
        
        for(Conta c : listConta) {
        	System.out.println("Nome: " + c.getCliente().getNome() + ", saldo: R$ " + c.getSaldo());
        	total += c.getSaldo();
        }
        System.out.println("---------------------------------");
        System.out.println("Total: R$ " + total);
	}
}