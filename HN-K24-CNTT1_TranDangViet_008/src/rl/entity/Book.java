package rl.entity;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private int year;
    private String description;
    private boolean isAvailable;

    public Book() {
    }

    public Book(String bookId, String bookName, String author, int year, String description, boolean isAvailable) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void inputData(Scanner sc) {
        do {
            System.out.print("Nhập mã sách (Bxxx): ");
            bookId = sc.nextLine();
        } while (!bookId.matches("B\\d{3}"));

        do {
            System.out.print("Nhập tên sách (>5 ký tự): ");
            bookName = sc.nextLine();
        } while (bookName.length() < 5);

        do {
            System.out.print("Nhập tác giả: ");
            author = sc.nextLine();
        } while (author.isEmpty());

        do {
            System.out.print("Nhập năm xuất bản (>1900, <=2026): ");
            year = Integer.parseInt(sc.nextLine());
        } while (year <= 1900 || year > 2026);

        System.out.print("Nhập mô tả: ");
        description = sc.nextLine();
        System.out.print("Trạng thái (true: có sẵn, false: đang mượn): ");
        isAvailable = Boolean.parseBoolean(sc.nextLine());
    }

    public void displayData() {
        String status = isAvailable ? "Có sẵn" : "Đang mượn";
        System.out.println(bookId + " | " + bookName + " | " + author + " | " + year + " | " + description + " | " + status);
    }
}
