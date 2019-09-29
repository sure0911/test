package com.sylm.entity;

import java.util.Date;

public class Book {
	String isbn;
	String name;
	int price;
	Date publishDate;

	public Book(String isbn, String name, int price, Date publishDate) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.publishDate = publishDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Book(String isbn, String name, int price) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
	}

	public Book() {
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book{" + "isbn='" + isbn + '\'' + ", name='" + name + '\'' + ", price=" + price + ", publishDate="
				+ publishDate + '}';
	}
}