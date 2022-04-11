package com.gl.javafsd.traveller.currency;

import java.util.Scanner;

public class TravellerCurrencyUI {

	private int[] denominations;

	Scanner sc = new Scanner(System.in);

	public void init() {

		gatherInputsAndProcess();
	}

	private void gatherInputsAndProcess() {

		System.out.println("Enter the size of the currency denominations:");
		int denominationsArraySize = sc.nextInt();
		denominations = new int[denominationsArraySize];

		System.out.println("Enter the currency denomination value(s):");
		for (int index = 0; index < denominationsArraySize; index++) {

			denominations[index] = sc.nextInt();
			sc.nextLine();
		}

		System.out.println("Enter the pay amount:");
		int payAmount = sc.nextInt();

		CurrencyDenominationsDeterminator determinator = new CurrencyDenominationsDeterminator(denominations,
				payAmount);
		determinator.determine();

	}
}