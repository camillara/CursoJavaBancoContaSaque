package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExecption;

public class Programa {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		try {
			System.out.println("Informe os dados para cadastrar a conta: ");
			System.out.print("Número da conta: ");
			Integer numeroConta = leia.nextInt();
			leia.nextLine();
			System.out.print("Nome: ");
			String nome = leia.nextLine().toUpperCase();
			System.out.print("Saldo inicial: ");
			Double saldoInicial = leia.nextDouble();
			System.out.print("Limite de saque: ");
			Double limiteSaque = leia.nextDouble();
			Account conta = new Account(numeroConta, nome, saldoInicial, limiteSaque);
			
			System.out.print("\nInforme o valor que deseja sacar: ");
			Double saque = leia.nextDouble();
			conta.saque(saque);
			System.out.println("Novo saldo R$ " + String.format("%.2f", conta.getSaldo()));
		}
		catch(DomainExecption e) {
			System.out.println("Atenção! " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.print("Ocorreu uma erro de input.");
		}
		leia.close();
	}

}
