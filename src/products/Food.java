package products;

// Open-closed principle - класс Food расширяет класс Product, при этом не изменяя его самого
public class Food extends Product {
    private int temperature;

    public Food(String name, int price, String country, int temperature) {
        super(name, price, country);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return getName() + " - " + getPrice() + " руб. " + "\n ~ Страна-производителя: " + getCountry()
                + "\n ~ температура хранения: " + getTemperature() + "°C";
    }
}