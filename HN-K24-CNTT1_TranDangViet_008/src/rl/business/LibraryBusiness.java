package rl.business;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import rl.entity.Book;

public class LibraryBusiness {
    private static LibraryBusiness instance;
    private List<Book> books;
    private LibraryBusiness(){
        books =  new ArrayList<>();
    }

    public static LibraryBusiness getInstance(){
        if (instance == null){
            instance = new LibraryBusiness();
        }
        return instance;
    }

    public void displayBooks(){
        if (books.isEmpty()){
            System.out.println("Danh sách rỗng");
        } else {
            books.forEach(System.out::println);
        }
    }

    public void addBook(Book book){
        boolean exists = books.stream().anyMatch(b -> b.getBookID().equals(book.getBookID()));
        if (exists){
            System.out.println("Mã sách đã tồn tại");
        } else  {
            books.add(book);
            System.out.println("Thêm sách thành công");
        }
    }

    public void updateBook(String id, Scanner scanner){
        Optional<Book> opt = books.stream().filter(b -> b.getBookID().equals(id)).findFirst();
        if (opt.isPresent()){
            Book book = opt.get();
            System.out.print("Nhập tên sách mới: ");
            String name =  scanner.nextLine();
            if (!name.isEmpty())
                book.setBookName(name);

            System.out.print("Nhập tác giả mới: ");
            String author =  scanner.nextLine();
            if (!author.isEmpty())
                book.setAuthor(author);

            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Mã sách không tồn tại");
        }
    }

    public void deleteBook(String id){
        Optional<Book> opt = books.stream().filter(b -> b.getBookID().equals(id)).findFirst();
        if (opt.isPresent()){
            if (opt.get().isAvailable()){
                books.remove(opt.get());
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Chỉ xóa được sách còn trong kho");
            }
        } else {
            System.out.println("Mã sách không tồn tại");
        }
    }

    public void searchByAuthor(String keyword){
        List<Book> result = books.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        if (result.isEmpty()){
            System.out.println("Không tìm thấy sách nào của tác giả chứa từ khóa: " + keyword);
        } else {
            result.forEach(Book::displayData);
            System.out.println("Tổng số tìm thấy: " + result.size());
        }
    }


}
