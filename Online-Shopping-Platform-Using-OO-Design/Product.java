import java.util.List;


public class Product{
    private String productId;
    private String name;
    private String description;
    private double price;
    private List<String> categories;
    private List<Review> reviews;

    public Product(String productId, String name, String description, double price, List<String> categories, List<Review> reviews){
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = categories;
        this.reviews = reviews;
    }

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public List<String> getCategories(){
        return categories;
    }

    public void setCategories(List<String> categories){
        this.categories = categories;
    }

    public List<Review> getReviews(){
        return reviews;
    }

    public void setReviews(List<Review> reviews){
        this.reviews = reviews;
    }
}