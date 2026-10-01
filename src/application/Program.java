package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data: ");
		System.out.print("\nName: ");
		String clientName = sc.nextLine();

		System.out.print("\nEmail: ");
		String clientEmail = sc.nextLine();

		System.out.print("\nBirth date (DD/MM/YYYY): ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date clientBirthDate = sdf.parse(sc.next());

		System.out.println("Enter order data: ");
		System.out.print("\nStatus: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, new Client(clientName, clientEmail, clientBirthDate));

		System.out.print("\nHow many items to this order? ");
		int numOfItems = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numOfItems; i++) {

			System.out.printf("Enter #%d item data: ", i + 1);
			System.out.print("\nProduct name: ");
			String productName = sc.nextLine();

			System.out.print("\nProduct price: ");
			Double productPrice = sc.nextDouble();

			System.out.print("\nQuantity: ");
			Integer quantity = sc.nextInt();
			sc.nextLine();

			order.addOrderItem(new OrderItem(quantity, productPrice, new Product(productName, productPrice)));
		}

		System.out.println("ORDER SUMMARY");
		System.out.println(order.toString());
		
		sc.close();

	}

}
