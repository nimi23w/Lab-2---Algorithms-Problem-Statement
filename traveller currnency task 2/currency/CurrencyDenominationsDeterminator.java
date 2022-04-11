package com.gl.javafsd.traveller.currency;

import java.util.Arrays;
import java.util.Collections;

public class CurrencyDenominationsDeterminator {

	private int[] denominations;
	private int payAmount;

	private int[] resultDenominationArray;
	private int[] resultDenominationCountArray;

	public CurrencyDenominationsDeterminator(int[] denominations, int payAmount) {
		this.denominations = denominations;
		this.payAmount = payAmount;

		this.resultDenominationArray = new int[this.denominations.length];
		this.resultDenominationCountArray = new int[this.denominations.length];
	}

	public void determine() {
		
		sort();
		
		int index = 0;
		int resultIndex = 0;
		int balancedOutPayAmount = payAmount;

		while (index < denominations.length) {

			int denomination = denominations[index];

			int quotient = balancedOutPayAmount / denomination;

			int remainder = balancedOutPayAmount % denomination;

			if (quotient != 0) {

				int temp = denomination * quotient;
				balancedOutPayAmount = balancedOutPayAmount - (temp);
				resultDenominationArray[resultIndex] = denomination;
				resultDenominationCountArray[resultIndex] = quotient;
				resultIndex++;

				if (remainder == 0) {
					if (balancedOutPayAmount == 0) {
						printSuccessMessage(resultIndex);
						break;
					}
				}

			} else {
				if (remainder != 0) {

					if (!isLastDenomination(index)) {
						// Continue with the next iteration
					} else {
						printErrorMessage();
						break;
					}
				} else if (remainder == 0) {
					// Both quotient and remainder are zero,
					break;
				}
			}
			index++;
		}

	}

	private void sort() {

		BubbleSort bubbleSort = new BubbleSort(denominations);		
		bubbleSort.sortDesc();
	}

	private boolean isLastDenomination(int index) {
		if (index == denominations.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	private void printErrorMessage() {
		System.out.println("For the denomination values " + Arrays.toString(denominations)
				+ ", it is not possible to give for the payment amount [" + payAmount + "]");
	}

	private void printSuccessMessage(int resultIndex) {

		resultDenominationArray = Arrays.copyOf(resultDenominationArray, resultIndex);

		resultDenominationCountArray = Arrays.copyOf(resultDenominationCountArray, resultIndex);

		System.out.println(
				"For the payment [" + payAmount + "] and for the denominations " + Arrays.toString(denominations)
						+ ", use the below method for giving the minimum number of notes :-");

		for (int index = 0; index < resultDenominationArray.length; index++) {

			int denomination = resultDenominationArray[index];
			int denominationCount = resultDenominationCountArray[index];

			System.out.println("Denomination [" + denomination + "] to be given [" + denominationCount + "] time(s)");
		}
	}

	public static void main(String[] args) {

		test(new int[] { 10, 5, 1 }, 12);
		test(new int[] { 78, 60, 25, 12, 5 }, 128);
		test(new int[] { 123, 18, 12, 5 }, 158);
		test(new int[] { 15 }, 10);
		test(new int[] { 25, 15 }, 10);

	}

	private static void test(int[] denominations, int payAmount) {

		System.out.println("---------------------------------------");
		CurrencyDenominationsDeterminator determinator = new CurrencyDenominationsDeterminator(denominations,
				payAmount);

		determinator.determine();
	}

}