package rl.business;

import rl.entity.Book;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryBusiness {
    private static LibraryBusiness instance;
    private List<Book> books;
    private LibraryBusiness() {
        books = new ArrayList<>();
    }

    public static LibraryBusiness getInstance() {
        if (instance == null) {
            instance = new LibraryBusiness();
        }
        return instance;
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách rỗng!");
        } else {
            books.forEach(Book::displayData);
        }
    }

    public void addBook(Book book) {
        if (books.stream().anyMatch(b -> b.getBookId().equals(book.getBookId()))) {
            System.out.println("Mã sách đã tồn tại");
        } else {
            books.add(book);
            System.out.println("Thêm thành công");
        }
    }

    public void updateBook(String id, Scanner sc) {
        Optional<Book> opt = books.stream().filter(b -> b.getBookId().equals(id)).findFirst();
        if (opt.isPresent()) {
            Book book = opt.get();
            System.out.print("Tên sách (Enter để bỏ qua): ");
            String name = sc.nextLine();
            if (!name.isEmpty()) book.setBookName(name);

            System.out.print("Tác giả (Enter để bỏ qua): ");
            String author = sc.nextLine();
            if (!author.isEmpty()) book.setAuthor(author);

            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Mã sách không tồn tại!");
        }
    }

    public void deleteBook(String id) {
        Optional<Book> opt = books.stream().filter(b -> b.getBookId().equals(id)).findFirst();
        if (opt.isPresent()) {
            Book book = opt.get();
            if (book.isAvailable()) {
                books.remove(book);
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Chỉ xóa được sách đang ở kho");
            }
        } else {
            System.out.println("Mã sách không tồn tại");
        }
    }

    public void searchByAuthor(String keyword) {
        List<Book> result = books.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        result.forEach(Book::displayData);
        System.out.println("Tìm thấy: " + result.size() + " sách");
    }

    public void sortByYearDesc() {
        books.stream()
                .sorted((b1, b2) -> Integer.compare(b2.getYear(), b1.getYear()))
                .forEach(Book::displayData);
    }
}
