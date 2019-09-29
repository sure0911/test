package com.sylm.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sylm.entity.Book;
import com.sylm.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@GetMapping("")
	public String getAll(Map<String, Object> map) {
		map.put("list", BookService.getAll());
		System.out.println("查询所有");
		System.out.println(map);
		return "list";
	}

	@GetMapping("/{isbn}")
	public String getBook(Map<String, Object> map, @PathVariable("isbn") String isbn) {
		map.put("book", BookService.getBook(isbn));
		System.out.println("查询一个" + map);
		return "book";
	}

	@DeleteMapping("/{isbn}")
	public String delete(@PathVariable("isbn") String isbn) {
		BookService.delete(isbn);
		System.out.println("删除一个" + isbn);
		return "redirect:/book";
	}

	@PutMapping("")
	public String update(Map<String, Object> map, Book book) {
		BookService.update(book);
		System.out.println("修改一个：" + book);
		return "redirect:/book";
	}

	@PostMapping("")
	public String save(Map<String, Object> map, Book book) {
		BookService.save(book);
		System.out.println("增加一个：" + book);
		return "redirect:/book";
	}

	@GetMapping("/index")
	public String index() {
		return "book";
	}
}