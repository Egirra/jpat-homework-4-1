import products.Product;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // используем константы, чтобы избежать магических чисел
    private static final int MIN_ORDER_AMOUNT = 500;
    private static int totalSum = 0;
    private static Shop shop = new Shop();
    private static ArrayList<Basket> order = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Добро пожаловать!");
        shop.fillCatalog();
        shop.fillInMenuItems();
        shop.printMenu();

        while (true) {
            System.out.println("Выберите действие в меню:");
            String input = scanner.nextLine();
            int item = Integer.parseInt(input);
            if (item == 6) break;
            // Interface-segregation-principle - большой интерфейс разделен на маленькие
            switch (item) {
                case 1:
                    shop.printCatalog();
                    break;
                case 2:
                    shop.sortedName();
                    break;
                case 3:
                    addInBasket();
                    break;
                case 4:
                    printBasket();
                    break;
                case 5:
                    checkout();
                    break;
                default:
                    System.out.println("Ошибка ввода! Повторите ввод еще раз.");
            }
        }
    }

    private static void addInBasket() {
        while (true) {
            System.out.println("0 - ВЫХОД В ОСНОВНОЕ МЕНЮ");
            System.out.println("Введите наименование товара из каталога: ");
            String productName = scanner.nextLine();
            if (productName.equals("0")) break;
            System.out.println("Введите количество товара: ");
            String count = scanner.nextLine();
            int productCount = Integer.parseInt(count);
            Product search = shop.catalogSearch(productName);
            if (search != null) {
                order.add(new Basket(search, productCount));
                    System.out.println("Товар добавлен в корзину");
            } else {
                System.out.println("Такой товар не найден");
            }
        }
    }

    // принцип DRY - повторяющийся код вывода корзины вынесен в отдельный метод
    private static void printBasket() {
        if (order.isEmpty()) {
            System.out.println("Ваша корзина пуста");
        } else {
            for (int i = 0; i < order.size(); i++) {
                totalSum += order.get(i).getProduct().getPrice() * order.get(i).getCount();
                System.out.println(i + 1 + ". " + order.get(i));
            }
        }
    }

    private static void checkout() {
        if (totalSum >= MIN_ORDER_AMOUNT) {
            Random random = new Random();
            printBasket();
            System.out.println("Заказ № " + random.nextInt(10_000) + " оформлен. Общая сумма заказа: " + totalSum);
        } else {
            System.out.println("~ Минимальная сумма заказа должна быть не менее " + MIN_ORDER_AMOUNT + " руб. ~");
        }
    }
}