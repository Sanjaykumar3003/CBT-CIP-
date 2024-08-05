package com.Task3_Library_management;

public class ExcutionPage {

	public ExcutionPage() {

		Librarypage library = new Librarypage();

		library.addBook(new Details_page("B1", "Book One"));
		library.addBook(new Details_page("B2", "Book Two"));

		System.out.println("Listing all books:");
		library.listBooks();

		System.out.println("Issuing Book One:");
		library.issueBook("B1");

		System.out.println("Listing all books after issuing one:");
		library.listBooks();

		System.out.println("Returning Book One:");
		library.returnBook("B1");

		System.out.println("Listing all books after returning one:");
		library.listBooks();
	}
}
