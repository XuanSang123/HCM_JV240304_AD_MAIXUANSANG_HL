package ra.service;

import ra.entity.Laptop;
import ra.entity.LaptopType;
import java.util.Scanner;

public class LaptopService {
    static Scanner sc = new Scanner(System.in);
    private static int size = 0;
    private static Laptop[] laptops = new Laptop[10];

    public static void displayLaptop() {
        if (size == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        for (int i = 0; i < size; i++) {
            Laptop laptop = laptops[i];
            String typeName = LaptopTypeService.getTypeNameById(laptop.getTypeId());
            System.out.println(laptop + " - Type: " + typeName);
        }
    }

    public static void addLaptop() {
        if (size >= laptops.length) {
            Laptop[] newLaptops = new Laptop[size + 1];
            System.arraycopy(laptops, 0, newLaptops, 0, laptops.length);
            laptops = newLaptops;
        }
        Laptop laptop = new Laptop();
        laptop.inputData();

        // Display available LaptopTypes
        LaptopTypeService.displayLaptopTypes();
        System.out.print("Chọn typeId cho laptop: ");
        int typeId = Integer.parseInt(sc.nextLine());

        if (LaptopTypeService.isTypeIdValid(typeId)) {
            laptop.setTypeId(typeId);
        } else {
            System.out.println("typeId không hợp lệ, thêm thất bại.");
            return;
        }

        laptops[size++] = laptop;
        System.out.println("Thêm thành công.");
    }

    public static void updateLaptop() {
        System.out.print("Nhập id cần chỉnh sửa: ");
        String id = sc.nextLine();

        for (int i = 0; i < size; i++) {
            if (laptops[i].getLaptopId().equals(id)) {
                System.out.println("Current details: " + laptops[i]);
                laptops[i].inputData();
                System.out.println("Chỉnh sửa thành công.");
                return;
            }
        }
        System.out.println("Laptop với id " + id +" không tìm thấy.");
    }

    public static void deleteLaptop() {
        System.out.print("Nhập id cần xoá: ");
        String id = sc.nextLine();
        for (int i = 0; i < size; i++) {
            if (laptops[i].getLaptopId().equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    laptops[j] = laptops[j + 1];
                }
                laptops[size - 1] = null;
                size--;
                System.out.println("Xoá thành công.");
                return;
            }
        }
        System.out.println("Laptop với id " + id + "không tìm thấy.");
    }
    public static void countLaptopsByType() {
        if (size == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        int[] typeCount = new int[LaptopTypeService.getSize()];
        for (int i = 0; i < size; i++) {
            int typeId = laptops[i].getTypeId();
            typeCount[typeId - 1]++;
        }

        System.out.println("Số lượng laptop theo từng loại:");
        for (int i = 0; i < typeCount.length; i++) {
            String typeName = LaptopTypeService.getTypeNameById(i + 1);
            System.out.println("Loại " + typeName + ": " + typeCount[i] + " laptop(s)");
        }
    }
}
