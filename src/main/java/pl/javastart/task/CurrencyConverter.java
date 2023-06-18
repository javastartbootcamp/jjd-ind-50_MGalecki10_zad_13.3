package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {


    static Map<String, BigDecimal> convertPriceToEuro(List<Product> productList, List<ExchangeRates> ratesList) {
        Map<String, BigDecimal> productsInEuro = new HashMap<>();
        for (Product product : productList) {
            for (ExchangeRates exchangeRates : ratesList) {
                if (product.getCurrencyCode().equals(exchangeRates.getCode())) {
                    BigDecimal priceInEuro = product.getPrice().divide(exchangeRates
                            .getEuroRatesToAnotherCurrency(), 2, RoundingMode.HALF_UP);
                    productsInEuro.put(product.getName(),priceInEuro);
                }
            }
        }
        return productsInEuro;
    }

    static BigDecimal getSumAllProductsInEuro(List<Product> productList, List<ExchangeRates> ratesList) {
        BigDecimal sum = BigDecimal.ZERO;
        Map<String, BigDecimal> priceInEuro = convertPriceToEuro(productList, ratesList);
        for (BigDecimal price : priceInEuro.values()) {
            sum = sum.add(price);
        }
        return sum;
    }

    static BigDecimal getAveragePriceInEuro(List<Product> productList, List<ExchangeRates> ratesList) {
        BigDecimal sumInEuro = getSumAllProductsInEuro(productList, ratesList);
        return sumInEuro.divide(BigDecimal.valueOf(productList.size()),2,RoundingMode.HALF_UP);
    }

    static Map<String, BigDecimal> getTheMostExpensiveProduct(List<Product> products, List<ExchangeRates> exchangeRates) {
        Map<String, BigDecimal> productsInEuro = convertPriceToEuro(products, exchangeRates);
        BigDecimal maxPrice = BigDecimal.ZERO;
        String theMostExpensiveProductName = null;
        for (Map.Entry<String, BigDecimal> entry : productsInEuro.entrySet()) {
            BigDecimal value = entry.getValue();
            if(value.compareTo(maxPrice) > 0) {
                maxPrice = value;
                theMostExpensiveProductName = entry.getKey();
            }
        }

        Map<String, BigDecimal> result = new HashMap<>();
        if (theMostExpensiveProductName != null) {
            result.put(theMostExpensiveProductName,maxPrice);
        }
        return result;
    }

    static Map<String, BigDecimal> getTheCheapestProduct(List<Product> products, List<ExchangeRates> exchangeRates) {
        Map<String, BigDecimal> productsInEuro = convertPriceToEuro(products, exchangeRates);
        BigDecimal minPrice = null;
        String theCheapestProductName = null;
        for (Map.Entry<String, BigDecimal> entry : productsInEuro.entrySet()) {
            BigDecimal value = entry.getValue();
            if(minPrice == null || value.compareTo(minPrice) < 0) {
                minPrice = value;
                theCheapestProductName = entry.getKey();
            }
        }

        Map<String, BigDecimal> result = new HashMap<>();
        if (theCheapestProductName != null) {
            result.put(theCheapestProductName,minPrice);
        }
        return result;
    }

}
