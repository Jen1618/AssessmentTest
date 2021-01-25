public class test extends assessmentTest{
	
	public static void main(String[] args){

		//First Customer who orders 2 orders of French fries
		
		Robot robot1 = new Robot(1);  //Creates the robot that will be in charge of your order 
		Customer customer1 = new Customer(1, 0);  //First parameter=customerId...the 2nd value is their previous balance but this is always 0
		Orders order = new Orders(customer1); 
		Chef frenchfries = new Chef(2);  //Parameter = number of French fries
		order.addItem(frenchfries);
		robot1.takeOrder(order);
		robot1.prepare();
		
		
		//Second Customer who orders 5 orders of French fries
		
		Robot robot2 = new Robot(2);
		Customer customer2 = new Customer(2, 0);
		Orders order2 = new Orders(customer2);
		Chef frenchfries2 = new Chef(5);
		order2.addItem(frenchfries2);
		robot2.takeOrder(order2);
		robot2.prepare();
		
	}
}
