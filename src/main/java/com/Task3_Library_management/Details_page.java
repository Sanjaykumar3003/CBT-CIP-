package com.Task3_Library_management;

public class Details_page {

	private String id;
	private String title;
	private boolean isIssued;

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean issued) {
		isIssued = issued;
	}

	public Details_page(String cons_id, String cons_title) {
		id = cons_id;
		title = cons_title;
		isIssued = false;

	}

	@Override
	public String toString() {
		return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", isIssued=" + isIssued + '}';
	}

}
