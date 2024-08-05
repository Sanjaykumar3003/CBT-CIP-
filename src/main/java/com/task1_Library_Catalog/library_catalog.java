package com.task1_Library_Catalog;

import java.util.ArrayList;
import java.util.List;

public class library_catalog {

	private List<Author_Book> books;

	public library_catalog() {
		books = new ArrayList<>();
		addInitialBooks();

	}

	private void addInitialBooks() {

		books.add(new Author_Book("1984", "George Orwell"));
		books.add(new Author_Book("To Kill a Mockingbird", "Harper Lee"));
		books.add(new Author_Book("The Great Gatsby", "F. Scott Fitzgerald"));
		books.add(new Author_Book("Pride and Prejudice", "Jane Austen"));
		books.add(new Author_Book("Moby-Dick", "Herman Melville"));
		books.add(new Author_Book("I Had a Love Story", "Ravinder Singh"));
		books.add(new Author_Book("The Alchemist", "Paulo Coelho"));
		books.add(new Author_Book("Five Point Someone", "Chetan Bhagat"));
		books.add(new Author_Book("The White Tiger", "Aravind Adiga"));
		books.add(new Author_Book("God of Small Things", "Arundhati Roy"));
		books.add(new Author_Book("One Piece", "Eiichiro Oda"));
		books.add(new Author_Book("Naruto", "Masashi Kishimoto"));
		books.add(new Author_Book("Attack on Titan", "Hajime Isayama"));
		books.add(new Author_Book("My Hero Academia", "Kohei Horikoshi"));
		books.add(new Author_Book("Death Note", "Tsugumi Ohba"));
	}

	public void addBook(String title, String author) {
		books.add(new Author_Book(title, author));
	}

	public void searchByTitle(String title) {
		boolean found = false;
		for (Author_Book book : books) {
			if (book.title.toLowerCase().contains(title.toLowerCase())) {
				System.out.println("Title: " + book.title + ", Author: " + book.author);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No books found with the title: " + title);
		}
	}

	public void searchByAuthor(String author) {
		boolean found = false;
		for (Author_Book book : books) {
			if (book.author.toLowerCase().contains(author.toLowerCase())) {
				System.out.println("Title: " + book.title + ", Author: " + book.author);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No books found by the author: " + author);
		}
	}

	public void listAllBooks() {
		if (books.isEmpty()) {
			System.out.println("No books in the catalog.");
		} else {
			for (int i = 0; i < books.size(); i++) {
				Author_Book book = books.get(i);
				System.out.println((i + 1) + ". Title: " + book.title + ", Author: " + book.author);
			}
		}
	}

	public void viewBookByIndex(int index) {
		if (index < 1 || index > books.size()) {
			System.out.println("Invalid index. Please try again.");
		} else {
			Author_Book book = books.get(index - 1);
			System.out.println("Title: " + book.title + ", Author: " + book.author);
		}
	}

}
