package rl.entity;
import java.time.Year;
import java.util.Scanner;

public class Book {
    private String bookID;
    private String bookName;
    private String author;
    private int year;
    private String description;
    private boolean isAvailable;

    public Book() {
    }

    public Book(String bookID, String bookName, String author, int year, String description, boolean isAvailable) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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

    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã sách: ");
            String id = scanner.nextLine();
            bookID = scanner.nextLine();
            if (id.matches("B\\d{3}")){
                this.bookID = bookID;
                break;
            } else {
                System.out.println("Mã sách không hợp lệ");
            }
        }

        do{
            System.out.print("Nhập tên sách (Ký tự > 5): ");
            this.bookName = scanner.nextLine();
        } while (bookName.length() > 5);

        do {
            System.out.print("Nhập tác giả: ");
            this.author = scanner.nextLine();
        } while (author.trim().isEmpty());

        while(true){
            System.out.print("Nhập năm xuất bản: ");
            try {
                int y= Integer.parseInt(scanner.nextLine());
                int currentYear = Year.now().getValue();
                if (y > 1900 && y <= currentYear){
                    this.year = y;
                    break;
                } else {
                    System.out.println("Năm xuất bản phải > 1900 và <= bằng" + currentYear);
                }
            } catch (NumberFormatException e) {
                System.out.println("Phải nhập số hợp lệ");
            }
        }

        System.out.print("Nhập mô tả: ");
        this.description = scanner.nextLine();

        System.out.print("Trạng thái (true: có sẵn, false: đang mượn");
        this.isAvailable = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData(){
        System.out.printf("| %-5s | %-20s | %-15s | %-4d | %-30s | %-10s |\n",bookID,bookName,author,year,description,isAvailable ? "Có sẵn" : "Đang mượn");
    }


}
