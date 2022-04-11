package com.gl.javafsd.paymoney.transaction;

import java.util.Arrays;

public class TargetAchievementCalculator {

	private int[] transactions;
	private int dailyTarget;
	private boolean dailyTargetAchieved;
	private int transactionCounter;

	public TargetAchievementCalculator(int[] transactions, int dailyTarget) {
		this.transactions = transactions;
		this.dailyTarget = dailyTarget;
		this.dailyTargetAchieved = false;
		this.transactionCounter = 0;
	}

	public void calculate() {

		int tempCounter = 0;

		for (int i = 0; i < transactions.length; i++) {

			int targetValue = transactions[i];
			tempCounter = tempCounter + targetValue;

			transactionCounter++;

			if (tempCounter >= dailyTarget) {
				dailyTargetAchieved = true;
				break;
			}
		}
	}

	public void printOutcome() {

		if (dailyTargetAchieved) {
			System.out.println("Daily target of [" + dailyTarget + "] is achieved after " + transactionCounter
					+ " transaction(s).");
		} else {
			System.out.println("Daily target of [" + dailyTarget + "] is NOT yet achieved!!");
		}
	}
	
	public static void main(String[] args) {
		
		test(new int [] {45,26,7,98}, 150);
		
		test(new int [] {20,10,25,5,64,72}, 50);
		
		test(new int [] {45,10,20,35,15}, 100);
		
		test(new int [] {40,30}, 80);

	}

	public static void test(int[] transactions, int dailyTarget) {
		
     	System.out.println("--------------------------------------------");
		System.out.println(Arrays.toString(transactions));				
		
		TargetAchievementCalculator calculate = new TargetAchievementCalculator(transactions, dailyTarget);
		calculate.calculate();
		calculate.printOutcome();
		
	}
}