package ra.run;

import ra.entity.LaptopType;
import ra.service.LaptopService;
import ra.service.LaptopTypeService;

import java.util.Scanner;

public class Main {
    static LaptopService laptopService = new LaptopService();
    static LaptopTypeService laptopTypeService = new LaptopTypeService();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("******************LAPTOP-MANAGEMENT******************\n" +
                    "1. Quản lý loại laptop\n" +
                    "2. Quản lý laptop \n" +
                    "3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            if (sc.hasNextLine()) {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        laptopTypeManagement();
                        break;
                    case 2:
                        laptopManagement();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn sai, vui lòng nhập lại");
                        break;
                }
            }
        }
    }

    public static void laptopTypeManagement() {
        while (true) {
            System.out.println("*******************LAPTOP_TYPE-MENU********************\n" +
                    "1. Hiển thị danh sách các loại laptop \n" +
                    "2. Thêm mới loại laptop\n" +
                    "3. Cập nhật thông tin loại laptop\n" +
                    "4. Xóa loại Laptop\n" +
                    "5. Thoát");
            System.out.print("Nhập lựa chọn: ");
            if (sc.hasNextLine()) {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        laptopTypeService.displayLaptopTypes();
                        break;
                    case 2:
                        laptopTypeService.addLaptopType();
                        break;
                    case 3:
                        laptopTypeService.updateLaptopType();
                        break;
                    case 4:
                        laptopTypeService.deleteLaptopType();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Nhập sai, vui lòng nhập lại");
                        break;
                }
            }
        }
    }

    public static void laptopManagement() {
        while (true) {
            System.out.println("********************LAPTOP-MENU*********************\n" +
                    "1. Danh sách Laptop\n" +
                    "2. Thêm mới Laptop\n" +
                    "3. Cập nhật thông tin Laptop\n" +
                    "4. Xóa Laptop\n" +
                    "5. Thống kê số lượng laptop theo từng loại\n" +
                    "6. Thoát");
            System.out.print("Nhập lựa chọn: ");
            if (sc.hasNextLine()) {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        laptopService.displayLaptop();
                        break;
                    case 2:
                        laptopService.addLaptop();
                        break;
                    case 3:
                        laptopService.updateLaptop();
                        break;
                    case 4:
                        laptopService.deleteLaptop();
                        break;
                    case 5:
                        laptopService.countLaptopsByType();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Nhập sai, vui lòng nhập lại");
                        break;
                }
            }
        }
    }
}
