package com.Task2_Bank_Interface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Account_OptionPage {

	private Map<String, BankAccount> accounts;
	private static final String FILE_NAME = "bank_accounts.ser";

	public Account_OptionPage() {
		accounts = new HashMap<>();
		loadAccounts();
	}

	public void createAccount(String accountHolderName) {
		BankAccount account = new BankAccount(accountHolderName);
		accounts.put(account.getAccountNumber(), account);
		saveAccounts();
		System.out.println("Account created successfully: " + account);
	}

	public BankAccount getAccount(String accountNumber) {
		return accounts.get(accountNumber);
	}

	public void listAccounts() {
		if (accounts.isEmpty()) {
			System.out.println("No accounts found.");
		} else {
			for (BankAccount account : accounts.values()) {
				System.out.println(account);
			}
		}
	}

	public void saveAccounts() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(accounts);
		} catch (IOException e) {
			System.out.println("Error saving accounts: " + e.getMessage());
		}
	}

	private void loadAccounts() {
	    File file = new File(FILE_NAME);
	    if (!file.exists()) {
	        System.out.println("No existing accounts found. Starting a new bank system.");
	        return;
	    }

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
	        Object obj = ois.readObject();
	        if (obj instanceof HashMap) {
	            accounts = (HashMap<String, BankAccount>) obj;
	        }
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Error loading accounts: " + e.getMessage());
	    }
	}

}
