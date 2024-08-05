package com.Task2_Bank_Interface;

import java.io.Serializable;
import java.util.Random;


public class BankAccount implements Serializable {
	

	private String accountNumber;
	private String accountHolderName;
	private double balance;

	public BankAccount(String current_accountHolderName) {
		accountNumber = generateAccountNumber(11, 16); 
		accountHolderName = current_accountHolderName;
		balance = 0.0;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public static String generateAccountNumber(int minLength, int maxLength) {
		Random random = new Random();
		int length = random.nextInt((maxLength - minLength) + 1) + minLength;
		StringBuilder accountNumber = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int digit = random.nextInt(10);
			accountNumber.append(digit);
		}

		return accountNumber.toString();
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Successfully deposited " + amount);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Successfully withdrew " + amount);
		} else {
			System.out.println("Invalid withdrawal amount or insufficient balance.");
		}
	}

	public void transfer(BankAccount toAccount, double amount) {
		if (toAccount != null && amount > 0 && amount <= balance) {
			this.withdraw(amount);
			toAccount.deposit(amount);
			System.out.println("Successfully transferred " + amount + " to " + toAccount.getAccountHolderName());
		} else {
			System.out.println("Invalid transfer amount or insufficient balance.");
		}
	}

	@Override
	public String toString() {
		return "Account Number: " + accountNumber + ", Account Holder: " + accountHolderName + ", Balance: " + balance;
	}
}
