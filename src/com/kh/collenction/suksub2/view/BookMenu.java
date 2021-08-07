package com.kh.collenction.suksub2.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.kh.collection.silsub2.controller.BookManager;
import com.kh.collection.silsub2.model.vo.Book;

public class BookMenu {

	private Scanner sc = new Scanner(System.in);
	private BookManager bm = new BookManager();

	public BookMenu() {
	}

	public void mainMenu() {

		while (true) {
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println("1.새 도서 추가");
			System.out.println("2.도서정보 정렬 후 출력");
			System.out.println("3.도서 삭제");
			System.out.println("4.도서 검색 출력");
			System.out.println("5.전체 출력");
			System.out.println("6.끝내기");

			System.out.print("메뉴 번호 선택: ");
			int num = sc.nextInt();
			sc.nextLine(); // 엔터를 치기 전까지 쓴 문자열 모두 리턴 ,
							// next() 스페이스 공백 전까지 입력 받은 문자열 리턴

			switch (num) {
			case 1:
				bm.addBook(inputBook());
				break;
			case 2:
				bm.printBookList(bm.sortedBookList());
				break;
			case 3:
				int result = bm.deleteBook(inputBookNo());
				if (result > 0) {
					System.out.println("삭제할 글이 존재하지 않음");
				} else {
					System.out.println("성공적으로 삭제");
				}
				break;
			case 4:
				int index = bm.serachBook(inputBookTitle());
				if (index == -1) {
					System.out.println("조회한 글이 존재하지 않음");
				} else {
					System.out.println(bm.selectBook(index));
				}
				break;
			case 5:
				ArrayList<Book> list = bm.selectAll();
				if (list.isEmpty()) {
					System.out.println("없습니다.");
				} else {
					Iterator it = list.iterator();
					while (it.hasNext()) {
						System.out.println(it.next());
					}
				}
				break;
			case 6:
				System.out.println("끝");
				return;
			}

		}

	}

	public Book inputBook() {
		System.out.print("도서 제목: ");
		String title = sc.nextLine();
		System.out.print("도서장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타): ");
		int category = sc.nextInt();
		sc.nextLine(); // ----위에 입력된 숫자는 리턴하지만 엔터는 남아있어 엔터값을 없애줘야한다.
		System.out.print("도서 저자: ");
		String author = sc.nextLine();
		
		return new Book(category, title, author);
	}

	public int inputBookNo() {
		System.out.print("도서 번호: ");
		int no = sc.nextInt();
		sc.nextLine();
		return no;

	}

	public String inputBookTitle() {
		System.out.println("도서 제목: ");
		String title = sc.nextLine();
		return title;
	}

}
