package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    static List<Product> readProductsFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<Product> products = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            products.add(new Product(split[0], new BigDecimal(split[1]), split[2]));
        }
        return products;
    }

    static List<ExchangeRates> readExchangeRatesFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<ExchangeRates> rates = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            rates.add(new ExchangeRates(split[0], new BigDecimal(split[1])));
        }
        return rates;
    }
}
