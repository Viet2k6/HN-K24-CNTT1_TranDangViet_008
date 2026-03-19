package rl.presentation;
import rl.entity.Book;
import rl.business.LibraryBusiness;
import java.util.Scanner;

public class LibaryManagement {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        LibraryBusiness business = LibraryBusiness.getInstance();

        while(true){
            System.out.println("----------QUẢN LÝ KHO HÀNG----------");
            System.out.println("1. Hiển thị danh sách toàn bộ sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Cập nhật thông tin theo mã sách");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Tìm sách theo tên tác giả");
            System.out.println("6. Thống kê tình trạng sách");
            System.out.println("7. Sắp xếp sách theo năm xuất bản giảm dần");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    business.displayBooks();
                    break;

                case 2:
                    do{
                        Book book = new Book();
                        book.inputData(scanner);
                        business.addBook(book);
                        System.out.print("Bạn có muốn thêm tiếp không? (Y/N): ");
                    } while (scanner.nextLine().equalsIgnoreCase("Y"));
                    break;

                case 3:
                    System.out.print("Nhập mã sách cần cập nhật: ");
                    business.updateBook(scanner.nextLine(), scanner);
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    business.deleteBook(scanner.nextLine());
                case 8:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ");

            }

        }
    }
}
