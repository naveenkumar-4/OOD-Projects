import java.util.HashMap;
import java.util.Map;;

public class Cart {
    private String userId;
    private Map<Product, Integer> items;

    public Cart(String userId) {
        this.userId = userId;
        this.items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {
        if (items.containsKey(product)) {
            items.put(product, quantity);
        }
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public double claculatedTotal() {
        return items.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setItems(Map<Product, Integer> items){
        this.items = items;
    }

}
