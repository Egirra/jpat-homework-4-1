package products;

import java.util.Comparator;

public class ProductsComparator implements Comparator<Product> {

    @Override
    public int compare(Product a, Product b) {
        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}