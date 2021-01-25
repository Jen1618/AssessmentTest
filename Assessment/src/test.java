public class test extends assessmentTest{
	
	public static void main(String[] args){
				
		Robot robot1 = new Robot(1);
		
		Customer customer1 = new Customer(1, 0);
		
		Orders order = new Orders(customer1);
		Chef frenchfries = new Chef(2);
		order.addItem(frenchfries);
		
		robot1.takeOrder(order);
		
		robot1.prepare();
		
		
		
		Robot robot2 = new Robot(2);
		
		Customer customer2 = new Customer(1, 0);
		
		Orders order2 = new Orders(customer2);
		Chef frenchfries2 = new Chef(5);
		order2.addItem(frenchfries2);
		
		robot2.takeOrder(order2);
		
		robot2.prepare();
		
	}
}
