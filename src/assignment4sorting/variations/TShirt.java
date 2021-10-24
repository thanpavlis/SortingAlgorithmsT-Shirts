package assignment4sorting.variations;

public class TShirt {

    private static int latestID = 1;

    private int id;
    private String color;
    private String size;
    private String fabric;
    private double price;

    public static int getLatestID() {
        return latestID;
    }

    public static void setLatestID(int aLatestID) {
        latestID = aLatestID;
    }

    public TShirt(String color, String size, String fabric) {
        this.id = latestID++;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
        calculatePrice();//ypologizei kai settarei thn timh analoga me ta color,size,fabric
    }

    private void calculatePrice() {//arxiki timh 20 + analoga tis times twn fields
        price = (20 + (double) (this.getColor().length() * 0.5)
                + (double) (this.getSize().length() * 0.5)
                + (double) (this.getFabric().length() * 0.5));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TShirt{id=").append(id);
        sb.append(", color=").append(color);
        sb.append(", size=").append(size);
        sb.append(", fabric=").append(fabric);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

}
