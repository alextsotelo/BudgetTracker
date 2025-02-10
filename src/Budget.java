import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

/**
 * The Budget class stores and manages the total budget, remaining budget,
 * transactions, and categories. It also handles saving and loading data to/from the file.
 */
public class Budget {
    private double totalBudget;
    private double remainingBudget;
    private ArrayList<Transaction> transactions;
    private ArrayList<String> categories;

    // Constructor initializes budget amounts and creates empty lists for transactions/categories
    public Budget() {
        totalBudget = 0.00;
        remainingBudget = 0.00;
        transactions = new ArrayList<>();
        categories = new ArrayList<>();

    }
    // Sets the total budget and resets remaining budget accordingly
    public void setTotalBudget(double budgetAmount) {
        totalBudget = budgetAmount;
        remainingBudget = budgetAmount;
    }
    // Sets the remaining budget
    public void setRemainingBudget (double budgetAmount) {
        remainingBudget = budgetAmount;
    }
    // Getter methods for total budget, remaining budget, categories, and transactions
    public double getTotalBudget() {
        return totalBudget;
    }
    public double getRemainingBudget() {
        return remainingBudget;
    }
    public ArrayList<String> getCategories() {
        return categories;
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Adds new transaction and deducts amount from remaining budget
    // If category is new, it is added to categories list
    public void addTransaction(double amount, String category) {
        Transaction newTransaction = new Transaction(amount, category);
        transactions.add(newTransaction);
        if (!categories.contains(category)) {
            categories.add(category);
        }
        remainingBudget -= amount;
    }
    // This method is specifically used only when loading transactions from saved file
    // without modifying the remaining budget.
    public void loadTransaction(double amount, String category) {
        Transaction newTransaction = new Transaction(amount, category);
        transactions.add(newTransaction);
        if (!categories.contains(category)) {
            categories.add(category);
        }
    }
    // Displays a summary of the total budget, remaining budget, and total spent so far
    public void budgetSummary() {
        System.out.println("|| BUDGET SUMMARY ||");
        System.out.printf("Total budget: $%.2f\n", totalBudget);
        System.out.printf("Remaining budget: $%.2f\n", remainingBudget);
        System.out.printf("Total spent so far: $%.2f\n", totalBudget - remainingBudget);
    }
    // Displays spending totals for each category
    public void spendingByCategory() {
        System.out.println("|| SPENDING BY CATEGORY ||");
        // Loop through each category and initialize it's total to zero
        for (String category : categories) {
            double categoryTotal = 0.00;
            // Loop through each transaction
            for (Transaction transaction : transactions) {
                // If transaction category equals current category
                if (transaction.getCategory().equals(category)) {
                    categoryTotal += transaction.getAmount();
                    // Add that transaction amount to the category
                }
            }
            System.out.printf("%s: $%.2f\n", category, categoryTotal);

        }
    }
    // Checks if a budget has been set to prevent user from accessing menu options before
    // they have set up a total budget
    public boolean isBudgetSet() {
        if (totalBudget == 0) {
            System.out.println("No budget set! Please set a budget first.");
            return false;
        }
        return true;
    }
    public void listTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.printf("Transaction %d: $%.2f (%s)\n", (i+1), transactions.get(i).getAmount(), transactions.get(i).getCategory());
        }
    }
    // Saves the total budget, remaining budget, and all transactions to a file
    public void saveData (String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".txt"));
            // Save total and remaining budget
            bw.write("Total Budget:" + totalBudget + "\n");
            bw.write("Remaining Budget:" + remainingBudget + "\n");
            // Save each transaction with its amount and category.
            for (Transaction transaction : transactions) {
                bw.write("Transaction:" + transaction.getAmount() + "," + transaction.getCategory() + "\n");
            }
            bw.close();
            System.out.println("Data saved successfully to " + filename + ".txt");

        } catch (Exception ex) {
            System.out.println("Unexpected error saving data.");
        }
    }
    // Loads budget data from a file (total budget, remaining budget, and all transactions)
    public void loadData (String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename + ".txt"));
            String s;
            // Read each line from the file
            while ( (s = br.readLine()) != null) {
                if (s.startsWith("Total Budget:")) {
                    String numberString = s.substring("Total Budget:".length());
                    totalBudget = Double.parseDouble(numberString);
                }
                else if (s.startsWith("Remaining Budget:")) {
                    String numberString = s.substring("Remaining Budget:".length());
                    remainingBudget = Double.parseDouble(numberString);
                }
                else if (s.startsWith("Transaction:")) {
                    String transactionString = s.substring("Transaction:".length());
                    String[] transactionData = transactionString.split(",");
                    double amount = Double.parseDouble(transactionData[0]);
                    String category = transactionData[1].trim();
                    // Load the transactions without modifying remaining budget
                    loadTransaction(amount, category);
                }
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("No previous data found. Starting new save");
        }

    }
}
