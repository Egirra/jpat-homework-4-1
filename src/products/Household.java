package products;

// Liskov substitution principle - наследник класса Product сможет сыграть роль своего предка
public class Household extends Product {
    private ProductCategory category;

    public Household(String name, int price, String country, ProductCategory category) {
        super(name, price, country);
        this.category = category;
    }

    @Override
    public String toString() {
        return getName() + " - " + getPrice() + " руб. " +
                "\n ~ Страна-производителя: " + getCountry() + "\nНазначение: " + category;
    }
}
