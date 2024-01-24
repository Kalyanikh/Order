import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Order {
    int orderNumber;
    int weight;
    String city;
    String pinCode;

    public Order(int orderNumber, int weight, String city, String pinCode) {
        this.orderNumber = orderNumber;
        this.weight = weight;
        this.city = city;
        this.pinCode = pinCode;
    }
}

class Container {
    String city;
    String pinCode;
    List<Order> orders;
    int currentWeight;

    public Container(String city, String pinCode) {
        this.city = city;
        this.pinCode = pinCode;
        this.orders = new ArrayList<>();
        this.currentWeight = 0;
    }

    public boolean canAddOrder(Order order) {
        return (currentWeight + order.weight) <= 1000;
    }

    public void addOrder(Order order) {
        orders.add(order);
        currentWeight += order.weight;
    }
}

public class OrderContainerOrganizer {
    public static void main(String[] args) {
        List<Order> orders = generateOrders(1000);
        List<Container> containers = organizeOrdersIntoContainers(orders);

       
        for (int i = 0; i < containers.size(); i++) {
            Container container = containers.get(i);
            System.out.println("Container " + (i + 1) + " - City: " + container.city + ", Pincode: " + container.pinCode);
        }
    }

    private static List<Order> generateOrders(int numberOfOrders) {
        List<Order> orders = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfOrders; i++) {
            int weight = random.nextInt(100) + 1;
            String pinCode = "Pin" + (i % 2 + 1);

            orders.add(new Order(i + 1, weight, city,pincode))
