package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> orderItems = new ArrayList<>();

	public Order() {

	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public double total() {
		double sum = 0;
		if (orderItems.size() > 0) {
			for (OrderItem item : orderItems) {
				sum += item.subTotal();
			}
		}

		return sum;
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}

	public void removeOrderItem(OrderItem orderItem) {
		orderItems.remove(orderItem);
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
			
		sb.append("Order moment: " + sdf.format(moment));
		sb.append("\nOrder status: " + status);
		sb.append("\nClient: " + client.toString());
		sb.append("\nOrder items:");
		
		for(OrderItem item: orderItems) {
			sb.append("\n" + item.toString());
		}
		
		sb.append("\nTotal price: " + total());
		
		return sb.toString();
	}

}
