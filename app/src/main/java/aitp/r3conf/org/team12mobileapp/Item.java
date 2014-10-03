package aitp.r3conf.org.team12mobileapp;

public class Item {

    int id;
    String name;
    String image;
    double price;
    int quantityInStack;
    String Category;

    // constructors
    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStack() {
        return quantityInStack;
    }

    public void setQuantityInStack(int quantityInStack) {
        this.quantityInStack = quantityInStack;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Item(int id, String name, String image, double price, int quantityInStack, String category) {

        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantityInStack = quantityInStack;
        Category = category;
    }

}
