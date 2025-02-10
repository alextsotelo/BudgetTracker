/**
 * The Transaction class represents a single financial transaction.
 * Each transaction has two properties: an amount, and a category.
 */
public class Transaction {
    private double amount;
    private String category;

    // Constructor to create a transaction
    public Transaction (double amount, String category) {
        this.amount = amount;
        this.category = category;
    }
    // Getter methods for amount, and category of transaction
    public double getAmount () {
        return amount;
    }
    public String getCategory () {
        return category;
    }
    // Setter methods for amount, and category of transaction
    public void setAmount (double amount) {
        this.amount = amount;
    }
    public void setCategory (String category) {
        this.category = category;
    }

}
