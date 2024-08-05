package com.Task2_Bank_Interface;

import java.util.Scanner;

public class Scanner_optionPage {

	public static void Scanner_Options() {

		Account_OptionPage ac_option = new Account_OptionPage();

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Banking System");
			System.out.println("1. Create account");
			System.out.println("2. Deposit funds");
			System.out.println("3. Withdraw funds");
			System.out.println("4. Transfer funds");
			System.out.println("5. List all accounts");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");
			int option = scan.nextInt();
			scan.nextLine();

			switch (option) {
			case 1:
				System.out.print("Enter account holder name: ");
				String name = scan.nextLine();
				ac_option.createAccount(name);
				break;
			case 2:
				System.out.print("Enter account number: ");
				String accountNumber = scan.nextLine();
				BankAccount depositAccount = ac_option.getAccount(accountNumber);
				if (depositAccount != null) {
					System.out.print("Enter amount to deposit: ");
					double depositAmount = scan.nextDouble();
					depositAccount.deposit(depositAmount);
					ac_option.saveAccounts();
				} else {
					System.out.println("Account not found.");
				}
				break;
			case 3:
				System.out.print("Enter account number: ");
				String withdrawAccountNumber = scan.nextLine();
				BankAccount withdrawAccount = ac_option.getAccount(withdrawAccountNumber);
				if (withdrawAccount != null) {
					System.out.print("Enter amount to withdraw: ");
					double withdrawAmount = scan.nextDouble();
					withdrawAccount.withdraw(withdrawAmount);
					ac_option.saveAccounts();
				} else {
					System.out.println("Account not found.");
				}
				break;
			case 4:
				System.out.print("Enter your account number: ");
				String fromAccountNumber = scan.nextLine();
				BankAccount fromAccount = ac_option.getAccount(fromAccountNumber);
				if (fromAccount != null) {
					System.out.print("Enter recipient account number: ");
					String toAccountNumber = scan.nextLine();
					BankAccount toAccount = ac_option.getAccount(toAccountNumber);
					if (true) {
						System.out.print("Enter amount to transfer: ");
						double transferAmount = scan.nextDouble();
						fromAccount.transfer(toAccount, transferAmount);
						ac_option.saveAccounts();
					} else {
						System.out.println("Recipient account not found.");
					}
				} else {
					System.out.println("Your account not found.");
				}
				break;
			case 5:
				ac_option.listAccounts();
				break;
			case 6:
				System.out.println("Exiting Banking System.");

				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
}
