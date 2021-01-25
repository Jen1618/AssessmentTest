import java.util.ArrayList;
import java.util.List;

public class assessmentTest {
	
	//This creates the robot and performs the task of taking the order from the customer
	
	static class Robot{
		
		private int robotId;
		List<Orders> orders = new ArrayList<Orders>(4);
		
		public Robot(int robotId){
			this.setRobotId(robotId);
			System.out.println("Hello my name is "+ robotId + " and I will be the robot taking your order.");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
				
		public boolean takeOrder(Orders order){
			Customer customer = order.getCustomer();
			boolean isDone = customer.check(order.totalPrice());
			
			if(isDone){
				orders.add(order);
				System.out.println("Your order is currently being processed.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return isDone;
		}
				
		public void prepare(){
			for(int i=0; i<orders.size(); i++){
				Orders order = orders.get(i);
				order.prepare();
			}
		}

		public int getRobotId() {
			return robotId;
		}

		public void setRobotId(int robotId) {
			this.robotId = robotId;
		}
	}

	static class Chef{
		
	//This class creates the Chef that will receive the order from the robot and the completion of the order is done here	
		
		private int itemId;
		private String itemName;
		private double price;
		private int amount;
		
		private int Id = 1;
		private String Name = "french fries";
		private double Price = 1.50;
		
		public Chef(int amt) {
			itemId = Id;
			itemName = Name;
			price = Price;
			amount = amt;
			
			System.out.println("You have "+ amount + " orders of French Fries on your tab.");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public int getItemId(){
			return itemId;
		}
		
		public String getItemName() {
			return itemName;
		}
		
		public double totalPrice(){
			return amount * price;
			
		}
		
		public void prepare(){
			cutPotato();
			fryPotato();
			finishOrder();
		}
		
		private void cutPotato(){
		}
		
		private void fryPotato(){
			System.out.println("The Chef is now preparing your order.");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		private void finishOrder(){
			System.out.println("Order is done.");
			System.out.println("The check for your order is $"+ totalPrice() +".");
			System.out.println();
		}
	}
	
	
	//This takes in the information of the customer and any previous balance they may have had
	
	static class Customer{
		private int customerId;
		private double starter;
		
		public Customer(int customerId, double startVal){
			this.setCustomerId(customerId);
			this.starter = startVal;
		}
		
		public boolean check(double tab){
			if(starter >= tab){
				starter -= tab;
				return false;
			}
			else {
				return true;
			}
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		
	}
	
	//This is more specific on what happens after the robot has gotten the order from the customer and sends it to the Chef
	
	static class Orders{
		private Customer customer;
		List<Chef> items = new ArrayList<Chef>(5);
		
		public Orders(Customer customer){
			this.customer = customer;
		}
		
		public Customer getCustomer(){
			return customer;
		}
		
		public void addItem(Chef item){
			items.add(item);
		}
		
		public void prepare(){
			for(int i=0; i<items.size(); i++){
				Chef item = items.get(i);
				item.prepare();
			}
		}
		
		public double totalPrice(){
			double total = 0.0;
			for(int i=0; i<items.size(); i++){
				Chef item = items.get(i);
				total += item.totalPrice();
			}
			return total;
		}
	}	
}
