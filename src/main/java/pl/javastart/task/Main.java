package pl.javastart.task;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String productsListName = "src/main/resources/products.csv";
        String currenciesListName = "src/main/resources/currencies.csv";

        try {
            List<Product> products = FileUtils.readProductsFromFile(productsListName);
            List<ExchangeRates> exchangeRates = FileUtils.readExchangeRatesFromFile(currenciesListName);

            showSumAllProducts(products, exchangeRates);
            showAveragePrice(products, exchangeRates);
            showMaxProduct(products, exchangeRates);
            showMinProduct(products, exchangeRates);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void showSumAllProducts(List<Product> products, List<ExchangeRates> exchangeRates) {
        BigDecimal sumAllProducts = CurrencyConverter.getSumAllProductsInEuro(products, exchangeRates);
        System.out.println("Suma wszystkich produktów w EUR wynosi " + sumAllProducts);
    }

    private static void showAveragePrice(List<Product> products, List<ExchangeRates> exchangeRates) {
        BigDecimal averagePrice = CurrencyConverter.getAveragePriceInEuro(products, exchangeRates);
        System.out.println("Średnia cena za produkty w EUR wynosi " +  averagePrice);
    }

    private static void showMaxProduct(List<Product> products, List<ExchangeRates> exchangeRates) {
        Map<String, BigDecimal> theMostExpensiveProduct = CurrencyConverter
                .getTheMostExpensiveProduct(products, exchangeRates);
        if(!theMostExpensiveProduct.isEmpty()) {
            String productName = theMostExpensiveProduct.keySet().iterator().next();
            BigDecimal productPrice = theMostExpensiveProduct.get(productName);
            System.out.println("Najdroższym produktem jest " + productName + " o wartosci " + productPrice);
        }
    }

    private static void showMinProduct(List<Product> products, List<ExchangeRates> exchangeRates) {
        Map<String, BigDecimal> theCheapestProduct = CurrencyConverter
                .getTheCheapestProduct(products, exchangeRates);
        if(!theCheapestProduct.isEmpty()) {
            String productName = theCheapestProduct.keySet().iterator().next();
            BigDecimal productPrice = theCheapestProduct.get(productName);
            System.out.println("Najtańszym produktem jest " + productName + " o wartosci " + productPrice);
        }
    }
}
