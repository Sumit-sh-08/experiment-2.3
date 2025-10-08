import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Product {
    String name;
    double price;
    String category;
    Product(String name, double price, String category) { this.name = name; this.price = price; this.category = category; }
    public String toString() { return name + " - " + price; }
}

public class ProductStream {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 80000, "Electronics"),
            new Product("Phone", 50000, "Electronics"),
            new Product("Shirt", 2000, "Clothing"),
            new Product("Jeans", 3000, "Clothing"),
            new Product("TV", 40000, "Electronics")
        );

        Map<String, List<Product>> grouped = products.stream()
            .collect(groupingBy(p -> p.category));
        System.out.println("Grouped by category: " + grouped);

        Map<String, Optional<Product>> maxPrice = products.stream()
            .collect(groupingBy(p -> p.category, maxBy(Comparator.comparingDouble(p -> p.price))));
        System.out.println("Most expensive per category: " + maxPrice);

        double avgPrice = products.stream()
            .collect(averagingDouble(p -> p.price));
        System.out.println("Average price: " + avgPrice);
    }
}
