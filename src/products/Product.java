package products;

public abstract class Product {
    private String name;
    private int price;
    private String country;

    public Product(String name, int price, String country) {
        this.name = name;
        this.price = price;
        this.country = country;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        return name + " - " + price + " руб. " + " ~ Страна-производителя: " + country;
    }
}