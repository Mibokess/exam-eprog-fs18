package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by mikeb on 12/3/2019
 */
class WarenAnalyse {
	static void analyse(File input, File output) throws FileNotFoundException {
		var transactions = new ArrayList<Transaction>();
		var consumers = new ArrayList<Consumer>();
		var products = new ArrayList<Product>();

		readInput(new Scanner(input), transactions, consumers, products);

		var highestProfitTransaction = Collections.max(transactions, Comparator.comparingDouble(Transaction::profit));
		var highestIncomeConsumer = Collections.max(consumers, Comparator.comparingDouble(Consumer::income));
		var highestDifferenceProduct = Collections.max(products, Comparator.comparingDouble(Product::maxDifference));

		printResult(new PrintStream(output), highestProfitTransaction, highestIncomeConsumer, highestDifferenceProduct);
	}

	private static void readInput(Scanner scanner, ArrayList<Transaction> transactions, ArrayList<Consumer> consumers, ArrayList<Product> products) {
		var consumersMap = new HashMap<String, Consumer>();
		var productsMap = new HashMap<String, Product>();

		while (scanner.hasNext()) {
			var productName = scanner.next();
			var consumerName = scanner.next();

			productsMap.putIfAbsent(productName, new Product(productName));
			consumersMap.putIfAbsent(consumerName, new Consumer(consumerName));

			var transaction = new Transaction(productsMap.get(productName), consumersMap.get(consumerName), scanner.nextInt(), scanner.nextDouble());

			transactions.add(transaction);
			productsMap.get(productName).transactions.add(transaction);
			consumersMap.get(consumerName).transactions.add(transaction);
		}

		products.addAll(productsMap.values());
		consumers.addAll(consumersMap.values());
	}

	private static void printResult(PrintStream output, Transaction highestProfitTransaction, Consumer highestIncomeConsumer, Product highestDifferenceProduct) {
		output.printf("%s %.2f\n", highestProfitTransaction.product.name, highestProfitTransaction.pricePerUnit);
		output.printf("%s %.2f\n", highestIncomeConsumer.name, highestIncomeConsumer.income());
		output.println(highestDifferenceProduct.name);
	}
}

class Transaction {
	Product product;
	Consumer consumer;
	int numberOfUnits;
	double pricePerUnit;

	Transaction(Product product, Consumer consumer, int numberOfUnits, double pricePerUnit) {
		this.product = product;
		this.consumer = consumer;
		this.numberOfUnits = numberOfUnits;
		this.pricePerUnit = pricePerUnit;
	}

	double profit() {
		return numberOfUnits * pricePerUnit;
	}
}

class Consumer {
	String name;
	List<Transaction> transactions;

	Consumer(String name) {
		this.name = name;
		this.transactions = new ArrayList<>();
	}

	double income() {
		double income = 0.0;

		for (Transaction transaction : transactions) {
			income += transaction.pricePerUnit * transaction.numberOfUnits;
		}

		return income;
	}
}

class Product {
	String name;
	ArrayList<Transaction> transactions;

	Product(String name) {
		this.name = name;
		this.transactions = new ArrayList<>();
	}

	double maxDifference() {
		return Collections.max(transactions, (o1, o2) -> Double.compare(o1.pricePerUnit, o2.numberOfUnits)).pricePerUnit
				- Collections.min(transactions, (o1, o2) -> Double.compare(o1.pricePerUnit, o2.numberOfUnits)).pricePerUnit;
	}
}
