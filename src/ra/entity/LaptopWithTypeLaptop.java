package ra.entity;

public class LaptopWithTypeLaptop {
    private LaptopType laptopType;
    private int totalLaptop;

    public LaptopWithTypeLaptop() {
    }

    public LaptopWithTypeLaptop(LaptopType laptopType, int totalLaptop) {
        this.laptopType = laptopType;
        this.totalLaptop = totalLaptop;
    }

    public LaptopType getLaptopType() {
        return laptopType;
    }

    public void setLaptopType(LaptopType laptopType) {
        this.laptopType = laptopType;
    }

    public int getTotalLaptop() {
        return totalLaptop;
    }

    public void setTotalLaptop(int totalLaptop) {
        if (totalLaptop >= 0) {
            this.totalLaptop = totalLaptop;
        } else {
            System.out.println("Total laptops must be non-negative.");
        }
    }

    @Override
    public String toString() {
        return "LaptopWithTypeLaptop{" +
                "laptopType=" + laptopType +
                ", totalLaptop=" + totalLaptop +
                '}';
    }
}
