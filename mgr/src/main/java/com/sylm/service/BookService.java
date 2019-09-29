package com.sylm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sylm.entity.Book;

public class BookService {

	static Map<String, Book> map = new HashMap<String, Book>();

	// 初始数据
	static {
		map.put("123456", new Book("123456", "世界是平的", 45, new Date()));
		map.put("123457", new Book("123457", "正年的奇迹", 75, new Date()));
		map.put("123458", new Book("123458", "浪潮之耟", 69, new Date()));
		map.put("123459", new Book("123459", "数学 之美丽", 58, new Date()));
	}

	public static void save(Book book) {
		map.put(book.getIsbn(), book);
	}

	public static void update(Book book) {
		map.put(book.getIsbn(), book);
	}

	public static void delete(String isbn) {
		map.remove(isbn);
	}

	public static List<Book> getAll() {
		return new ArrayList<Book>(map.values());
	}

	public static Book getBook(String isbn) {
		return map.get(isbn);
	}
}
