package com.Task3_Library_management;

import java.util.HashMap;
import java.util.Map;

public class Librarypage {

	private Map<String, Details_page> books;

	public Librarypage() {
		books = new HashMap<>();
	}

	public void addBook(Details_page book) {
		books.put(book.getId(), book);
		System.out.println("Book added: " + book.getTitle());
	}

	public void issueBook(String bookId) {
		Details_page book = books.get(bookId);
		if (book != null && !book.isIssued()) {
			book.setIssued(true);
			System.out.println("Book issued: " + book.getTitle());
		} else {
			System.out.println("Book is not available for issue.");
		}
	}

	public void returnBook(String bookId) {
		Details_page book = books.get(bookId);
		if (book != null && book.isIssued()) {
			book.setIssued(false);
			System.out.println("Book returned: " + book.getTitle());
		} else {
			System.out.println("Book was not issued.");
		}
	}

	public void listBooks() {
		for (Details_page book : books.values()) {
			System.out.println(book);
		}
	}
}
