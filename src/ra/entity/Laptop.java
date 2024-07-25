package ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Laptop {
    private String laptopId, laptopName, description;
    private int ram, typeId;
    private double weight, laptopPrice;
    private Date createAt;
    private boolean isDelete;
    public static int auto = 1;

    public Laptop() {
    }

    public Laptop(String laptopId, String laptopName, String description, int ram, int typeId, double weight, double laptopPrice, Date createAt, boolean isDelete) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
        this.description = description;
        this.ram = ram;
        this.typeId = typeId;
        this.weight = weight;
        this.laptopPrice = laptopPrice;
        this.createAt = createAt;
        this.isDelete = isDelete;
    }

    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(double laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public static int getAuto() {
        return auto;
    }

    public static void setAuto(int auto) {
        Laptop.auto = auto;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.print("Mã của laptop (LXXX): ");
            String laptopId = sc.nextLine();
            if (Pattern.matches("^L\\d{3}$", laptopId)) {
                this.laptopId = laptopId;
                break;
            } else {
                System.out.println("Nhập chưa đúng định dạng, vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Tên của laptop: ");
            String laptopName = sc.nextLine();
            if (!laptopName.isEmpty() && !laptopName.equals(this.laptopName)) {
                this.laptopName = laptopName;
                break;
            } else {
                System.out.println("Tên không được để trống và không trùng lặp với tên hiện tại.");
            }
        }

        while (true) {
            System.out.print("Mô tả của laptop: ");
            String description = sc.nextLine();
            if (!description.isEmpty()) {
                this.description = description;
                break;
            } else {
                System.out.println("Mô tả không được để trống.");
            }
        }

        while (true) {
            try {
                System.out.print("RAM của laptop (GB): ");
                int ram = Integer.parseInt(sc.nextLine());
                if (ram > 0) {
                    this.ram = ram;
                    break;
                } else {
                    System.out.println("RAM phải lớn hơn 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại.");
            }
        }

        while (true) {
            try {
                System.out.print("Cân nặng laptop (kg): ");
                double weight = Double.parseDouble(sc.nextLine());
                if (weight > 0) {
                    this.weight = weight;
                    break;
                } else {
                    System.out.println("Cân nặng phải lớn hơn 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại.");
            }
        }

        while (true) {
            try {
                System.out.print("Giá của laptop: ");
                double laptopPrice = Double.parseDouble(sc.nextLine());
                if (laptopPrice > 0) {
                    this.laptopPrice = laptopPrice;
                    break;
                } else {
                    System.out.println("Giá phải lớn hơn 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Ngày nhập kho (yyyy-MM-dd): ");
            try {
                Date createAt = sdf.parse(sc.nextLine());
                this.createAt = createAt;
                break;
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ, vui lòng nhập lại.");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập loại máy tính (ID): ");
                int typeId = Integer.parseInt(sc.nextLine());
                if (typeId > 0) {
                    this.typeId = typeId;
                    break;
                } else {
                    System.out.println("ID loại máy tính không hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ, vui lòng nhập lại.");
            }
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String createDateStr = (createAt != null) ? sdf.format(createAt) : "N/A";
        return "Laptop{" +
                "laptopId='" + laptopId + '\'' +
                ", laptopName='" + laptopName + '\'' +
                ", description='" + description + '\'' +
                ", ram=" + ram +
                ", typeId=" + typeId +
                ", weight=" + weight +
                ", laptopPrice=" + laptopPrice +
                ", createAt=" + createDateStr +
                ", isDelete=" + isDelete +
                '}';
    }
}
