package org.globant.secondexercise;

import java.math.BigInteger;

import java.util.List;
import java.util.Optional;

public class Streams {

    /**
     * Default List of  BigInteger numbers.
     */
    public static List<BigInteger> randomNumbers = List.of(
            BigInteger.valueOf((long) (Math.random()*100)),
            BigInteger.valueOf((long) (Math.random()*100)),
            BigInteger.valueOf((long) (Math.random()*100)));


    /** Uses the stream API to filter a list of products with  colors blue, red or yellow.
     * @param numbers
     * @return BigInteger the sum of the numbers in the list.
     */
    public static BigInteger numberAdder(List<BigInteger> numbers){
       return numbers.stream().reduce(BigInteger.valueOf(0), BigInteger::add);
    }

    /** Uses the stream API to filter the products with  colors blue, red or yellow.
     * @param products
     * @return List of products with the applied filters.
     */
    public static List<Product> productsBlueRedOrYellow(List <Product> products){
        return Optional.of(products.stream().filter(product ->
                product.color==Color.BLUE ||
                product.color==Color.RED ||
                product.color==Color.YELLOW)
                ).orElse(null).toList();
    };

    /**
     * Default List of  products.
     */
    public static List<Product> randomProducts = List.of(
            new Product("142-ak4cs", "Office chair", Color.BLACK, 350.0),
            new Product("132-bc39f", "Gel pen", Color.RED, 1.0),
            new Product("102-a9fb3", "Umbrella", Color.BLUE, 8.0),
            new Product("112-c934k", "Marker", Color.YELLOW, 2.0),
            new Product("142-c19l1", "Marker", Color.RED, 2.5)
    );
}
