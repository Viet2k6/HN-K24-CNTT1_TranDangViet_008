package rl.presentation;

import rl.entity.Book;
import rl.business.LibraryBusiness;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryBusiness lb = LibraryBusiness.getInstance();
        while (true) {
            System.out.println("------------- QUẢN LÝ KHO SÁCH -------------");
            System.out.println("1. Hiển thị danh sách toàn bộ sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Cập nhật thông tin sách theo mã");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Tìm sách theo tên tác giả");
            System.out.println("6. Sắp xếp sách theo năm xuất bản giảm dần");
            System.out.println("7. Thống kê");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    lb.displayBooks();
                    break;
                case 2:
                    while (true) {
                        Book book = new Book();
                        book.inputData(sc);
                        lb.addBook(book);
                        System.out.print("Bạn có muốn tiếp tục thêm không? (Y/N): ");
                        String answer = sc.nextLine();
                        if (answer.equalsIgnoreCase("N")) {
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần cập nhật: ");
                    String idUpdate = sc.nextLine();
                    lb.updateBook(idUpdate, sc);
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String idDelete = sc.nextLine();
                    lb.deleteBook(idDelete);
                    break;
                case 5:
                    System.out.print("Nhập tên tác giả: ");
                    String keyword = sc.nextLine();
                    lb.searchByAuthor(keyword);
                    break;
                case 6:
                    lb.sortByYearDesc();
                    break;
                case 8:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }
    }
}
