package com.task1_Library_Catalog;

import java.util.Scanner;

public class ScannerOptions {

	public static void Scan_options() {

		library_catalog catalog = new library_catalog();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Library Catalog System");
			System.out.println("1. Add book");
			System.out.println("2. Search by title");
			System.out.println("3. Search by author");
			System.out.println("4. List all books");
			System.out.println("5. View book by index");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");
			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 1:
				System.out.print("Enter title: ");
				String title = scanner.nextLine();
				System.out.print("Enter author: ");
				String author = scanner.nextLine();
				catalog.addBook(title, author);
				System.out.println("Book added successfully!");
				break;

			case 2:
				System.out.print("Enter title to search: ");
				String searchTitle = scanner.nextLine();
				catalog.searchByTitle(searchTitle);
				break;

			case 3:
				System.out.print("Enter author to search: ");
				String searchAuthor = scanner.nextLine();
				catalog.searchByAuthor(searchAuthor);
				break;

			case 4:
				catalog.listAllBooks();
				break;

			case 5:
				System.out.print("Enter index of the book to view: ");
				int index = scanner.nextInt();
				catalog.viewBookByIndex(index);
				break;

			case 6:
				System.out.println("Exiting Library Catalog System.");
				scanner.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

}
