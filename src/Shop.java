import products.*;

import java.util.Arrays;
import java.util.List;

public class Shop {
    private List<Product> catalog;
    private List<String> menu;

    public void fillCatalog() {
        catalog = Arrays.asList(
                new Food("Хлеб", 50, "Россия", 25),
                new Household("Зубная паста", 150, "Корея", ProductCategory.HYGIENE),
                new Food("Сыр", 250, "Беларусь", 6),
                new Household("Зубная щетка", 80, "Китай", ProductCategory.ACCESSORIES),
                new Food("Колбаса", 200, "Россия", 6),
                new Household("Стиральный порошок", 200, "Великобритания", ProductCategory.DOMESTIC_CHEMICALS),
                new Food("Масло", 150, "Беларусь", -19),
                new Household("Швабра", 300, "Китай", ProductCategory.CLEANING_EQUIPMENT),
                new Food("Гречневая крупа", 100, "Россия", 25)
        );
    }

    public void printCatalog() {
        for (Product item : catalog) {
            System.out.println(item);
        }
    }

    public void sortedName() {
        catalog.stream()
                .sorted(new ProductsComparator())
                .forEach(System.out::println);
    }

    public Product catalogSearch(String name) {
        for (Product desiredProduct : catalog) {
            if (desiredProduct.getName().equalsIgnoreCase(name)) {
                return desiredProduct;
            }
        }
        return null;
    }

    public void fillInMenuItems() {
        menu = Arrays.asList(
                "Посмотреть каталог",
                "Отсортировать каталог по наименованию",
                "Добавить товар в корзину",
                "Посмотреть корзину",
                "Оформить заказ",
                "Выход"
        );
    }

    public void printMenu() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + 1 + ". " + menu.get(i));
        }
    }
}