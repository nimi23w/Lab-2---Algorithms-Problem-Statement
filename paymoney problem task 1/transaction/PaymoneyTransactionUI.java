package com.gl.javafsd.paymoney.transaction;

import java.util.Scanner;

public class PaymoneyTransactionUI {
	
	private int[] transactions;
	
	Scanner sc = new Scanner(System.in);
	
	public void	init() {
	
		gatherInputsAndProcess();
	
	}
	
	private void gatherInputsAndProcess() {
		
		System.out.println("Enter size of transaction array : ");
		int transactionArraySize = sc.nextInt();
		transactions = new int[transactionArraySize];
		
		System.out.println("Enter array element(s) : ");
		
		for(int i = 0; i < transactionArraySize; i++) {
			transactions[i] = sc.nextInt();
		}
		
		System.out.println("Enter the no. of transaction targets to be achieved :");
		int transactionInstances = sc.nextInt();
		
		for (int i = 1; i <= transactionInstances; i ++) {

			System.out.println();
			System.out.print("Enter the target value :");
			int dailyTarget = sc.nextInt();

			sc.nextLine();

			System.out.println("Processing transaction with value -> " + dailyTarget);
			
			TargetAchievementCalculator calculator = new TargetAchievementCalculator(transactions, dailyTarget);
			
			calculator.calculate();
			
			calculator.printOutcome();
		}
	}
	
	
}