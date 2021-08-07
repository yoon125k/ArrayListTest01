package com.kh.collection.silsub2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.collection.silsub2.model.dao.BookDao;
import com.kh.collection.silsub2.model.vo.Book;

public class BookManager {

	BookDao bd = new BookDao();
	Scanner sc = new Scanner(System.in);

	public BookManager() {
	}

	public void addBook(Book book) {
		try {
			book.setbNo(bd.getLastBookNo() + 1);
		} catch (IndexOutOfBoundsException e) {
			book.setbNo(1);
		}
		bd.addBook(book);
	}

	public int deleteBook(int no) {
		return bd.deleteBook(no);
	}

	public int serachBook(String title) {

		return bd.searchBook(title);
	}

	public Book selectBook(int index) {
		return bd.selectBook(index);
	}

	public ArrayList<Book> selectAll() {
		return bd.selectAll();
	}

	public Book[] sortedBookList() {
		ArrayList<Book> list = bd.sortedBookList();

		Book[] bk = new Book[list.size()];
		for (int i = 0; i < bk.length; i++) {
			bk[i] = list.get(i);
		}
		return bk;
	}

	public void printBookList(Book[] br) {
		for (Book temp : br) {
			System.out.println(temp);
		}

	}

}
