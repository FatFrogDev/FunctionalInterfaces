package org.globant.bonustrack;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        * Default List of  products.
        */
        List<Product> products = List.of(
                new Product("242-ak4cs", "Office chair", Color.BLACK, 350.0),
                new Product("632-bc39f", "Gel pen", Color.RED, 1.0),
                new Product("152-a9fb3", "Umbrella", Color.BLUE, 8.0),
                new Product("182-c934k", "Marker", Color.YELLOW, 2.0),
                new Product("111-c19l1", "Marker", Color.RED, 2.5)
        );

        // Bonus track 1
        System.out.println("Products with taxes of IVA applied");
        products.forEach(p -> p.setPrice(p.getPrice() + (p.getPrice() * 0.19)));
        products.forEach(System.out::println);
        System.out.println(System.lineSeparator());


        // Bonus track 2
        System.out.println("The products with the maximum price is : " +
                products.stream().map(p->{
                    return p;
                }).max((p1, p2) -> p1.getPrice().compareTo(p2.getPrice())).get().toString()
        );
        System.out.println(System.lineSeparator());


        // Bonus track 3
        // ALTERNATIVE 1, concatenating the description and the price comparators.
        System.out.println("Products filtered by price (descendant): ");
        products.stream()
                .sorted((p1,p2) -> (int) (p1.getPrice()+p2.getPrice()))
                .sorted((p1,p2) -> p1.getDescription().compareTo(p2.getDescription()))
                .forEach(System.out::println);

        /* ALTERNATIVE 2

        products.stream()
                .sorted((p1,p2) -> (int) (p1.getPrice()+p2.getPrice()))
                .forEach(System.out::println);

        System.out.println("Products filtered by decripcion (ascendant) and price (descendant): ");

        products.stream()
                .sorted((p1,p2) -> p1.getDescription().compareTo(p2.getDescription()))
                .forEach(System.out::println);

        */
    }
}
