package com.CS489.Lab.Lab1.Tasks.task4;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55),
                new Product(2927458265L, "Apple", "2022-12-09", 18, 1.09),
                new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99)
        };
        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        Stream<Product> sortedProducts = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName));
        System.out.println("JSON-formatted of all Products:");
        String jsonOutput = sortedProducts
                .map(p -> String.format("{\"productId\": \"%d\", \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f}",
                        p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()))
                .collect(Collectors.joining(",\n", "[\n", "\n]"));
        System.out.println(jsonOutput);
        sortedProducts = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName));
        System.out.println("\nXML-formatted of all Products:");
        String xmlOutput = sortedProducts
                .map(p -> String.format("  <product>\n    <productId>%d</productId>\n    <name>%s</name>\n    <dateSupplied>%s</dateSupplied>\n    <quantityInStock>%d</quantityInStock>\n    <unitPrice>%.2f</unitPrice>\n  </product>",
                        p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()))
                .collect(Collectors.joining("\n", "<products>\n", "\n</products>"));
        System.out.println(xmlOutput);
        sortedProducts = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName));
        System.out.println("\nCSV-formatted of all Products:");
        String csvOutput = sortedProducts
                .map(p -> String.format("%d,%s,%s,%d,%.2f",
                        p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()))
                .collect(Collectors.joining("\n", "ProductId,Name,DateSupplied,QuantityInStock,UnitPrice\n", ""));
        System.out.println(csvOutput);
    }
}