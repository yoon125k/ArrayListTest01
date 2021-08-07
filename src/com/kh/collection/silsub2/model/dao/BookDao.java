package com.kh.collection.silsub2.model.dao;

import java.util.ArrayList;

import com.kh.collection.silsub2.comparator.AscCategory;
import com.kh.collection.silsub2.model.vo.Book;

public class BookDao {

	private ArrayList<Book> bookList;

	public BookDao() {
		bookList = new ArrayList<Book>();
	}

	public BookDao(ArrayList<Book> list) {
		bookList = list;
	}

	public int getLastBookNo() {
		return bookList.get(bookList.size() - 1).getbNo();
	}

	public void addBook(Book book) {
		bookList.add(book);
	}

	public int deleteBook(int no) {
		int result = 0;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getbNo() == no) {
				bookList.remove(i);
				result = 1;
			}
		}
		return result;
	}

	public int searchBook(String title) {
		int index = -1; // ----?
		for(int i=0; i<bookList.size(); i++) {
			if (bookList.get(i).getTitle().contains(title)){
				index = i;
				break;
			}
		}
		return index;
		
	}

	public Book selectBook(int index) {
		return bookList.get(index);

	}

	public ArrayList<Book> selectAll() {
		return bookList;
	}

	public ArrayList<Book> sortedBookList() {
		bookList.sort(new AscCategory());
		return bookList;
	}

}
