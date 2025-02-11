import java.util.Scanner;
import java.io.*;

/**
 * Main class for the Budget Tracker application
 * This class handles the user-interaction via a command-line menu,
 * and uses the Budget Class to manage all budget-related data,
 * as well as the Transaction clas to manage all transactions.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        Budget budget = new Budget();

        // Load saved data from file (if it exists)
        budget.loadData("budgetTrackerData");
        boolean running = true;

        // Main Menu of the Program
        while (running) {
            System.out.println("\n=== Budget Tracker Menu ===");
            System.out.println("1. Set Monthly Budget");
            System.out.println("2. Add Transaction");
            System.out.println("3. View Budget Summary");
            System.out.println("4. View Spending by Category");
            System.out.println("5. View All Transactions");
            System.out.println("6. Edit/Delete Transaction");
            System.out.println("7. Reset Budget, Transactions, Categories");
            System.out.println("8. Exit Program (Save Data)\n");

            System.out.print("Enter an option: ");
            int userChoice = scnr.nextInt();
            scnr.nextLine(); // Consume new line to avoid any issues in future user inputs (ex: reading String after integer)

            // Handle user's menu choice with a switch-case
            switch (userChoice) {
                case (1):
                    // Option 1: Set the total monthly budget
                    System.out.print("Enter your total monthly budget: ");
                    double budgetAmount = scnr.nextDouble();
                    scnr.nextLine();
                    if (budgetAmount <= 0) {
                        System.out.println("Amount must be positive. Please try again");
                        break;
                    }
                    budget.setTotalBudget(budgetAmount);
                    break;
                case (2):
                    // Option 2: Add a new transaction
                    if (!budget.isBudgetSet()) {
                        break;
                    }

                    System.out.print("Enter the amount: ");
                    double transactionAmount = scnr.nextDouble();
                    scnr.nextLine(); // Consume new line

                    // Verify amount is positive
                    if (transactionAmount <= 0) {
                        System.out.println("Amount must be positive. Please try again.");
                        break;
                    }
                    // Prompt for a category name if none currently exist
                    if (budget.getCategories().isEmpty()) {
                        System.out.print("Enter the category: ");
                        String transactionCategory = scnr.nextLine();
                        budget.addTransaction(transactionAmount,transactionCategory);

                        System.out.println("Transaction added successfully.");
                    }
                    else {
                        // If categories exist, list them for the user to choose via inputting
                        // corresponding number, or type a new category name to create
                        int index = 1;
                        for (String category : budget.getCategories()) {
                            System.out.println(index + ") " + category);
                            ++index;
                        }
                        System.out.print("Enter the number of an existing category, or type a new category name: ");
                        String userInput = scnr.nextLine();
                        try {
                            // Try parsing the input as a number (for existing category)
                            int categoryNum = Integer.parseInt(userInput);
                            if (categoryNum >= 1 && categoryNum <= budget.getCategories().size()) {
                                String selectedCategory = budget.getCategories().get(categoryNum - 1);
                                budget.addTransaction(transactionAmount,selectedCategory);

                                System.out.println("Transaction added successfully.");

                            }
                            else {
                                System.out.println("Please enter a valid category number.");
                            }
                        } catch (NumberFormatException e) {
                            // If input isn't a number, then it's a new category name the user has entered to be added
                            if (userInput.trim().isEmpty()) {
                                System.out.println("Name cannot be empty. Please try again");
                            }
                            // Check if category already exists, ignoring case
                            boolean categoryExists = false;
                            for (String existingCategory : budget.getCategories()) {
                                if (existingCategory.equalsIgnoreCase(userInput)) {
                                    System.out.println("That category already exists. Please select it using the number that corresponds to it.");
                                    categoryExists = true;
                                    break;
                                }
                            }
                            // Add transaction if category is unique
                            if (!categoryExists) {
                                budget.addTransaction(transactionAmount, userInput);
                                System.out.println("Transaction added successfully.");
                            }
                        }
                    }
                    break;
                case (3):
                    // Option 3: Display budget summary
                    if (!budget.isBudgetSet()) {
                        break;
                    }

                    budget.budgetSummary();
                    break;
                case (4):
                    // Option 4: Display spending by category breakdown
                    if (!budget.isBudgetSet()) {
                        break;
                    }

                    if (budget.getTransactions().isEmpty()) {
                        System.out.println("No transactions available.");
                    }
                    else {
                        budget.spendingByCategory();
                    }
                    break;
                case (5):
                    // Option 5: List all transactions
                    if (!budget.isBudgetSet()) {
                        break;
                    }
                    if (budget.getTransactions().isEmpty()) {
                        System.out.println("No transactions available to view.");
                    } else {
                        // List all transactions in numbered list
                        budget.listTransactions();
                    }
                    break;
                case (6):
                    // Option 6: Edit or delete an existing transaction
                    if (!budget.isBudgetSet()) {
                        break;
                    }

                    if (budget.getTransactions().isEmpty()) {
                        System.out.println("No transactions available to modify.");
                    }
                     else {
                         // List all transactions with an index for selection
                        budget.listTransactions();

                        System.out.print("Please enter a transaction number to modify: ");
                        int transNum = scnr.nextInt();
                        if (transNum >= 1 && transNum <= budget.getTransactions().size()) {
                            System.out.print("Enter 1 to modify the transaction, or 2 to delete it: ");
                            int transNumOption = scnr.nextInt();
                            if (transNumOption == 1) {
                                // Option to modify a transaction's value
                                // Update remaining budget: refund old amount and subtract new amount
                                System.out.print("Enter the new value for the transaction: ");
                                double newTransValue = scnr.nextDouble();
                                // Verify amount is positive
                                if (newTransValue <= 0) {
                                    System.out.println("Amount must be positive. Please try again.");
                                    break;
                                }

                                double oldAmount = budget.getTransactions().get(transNum - 1).getAmount();
                                budget.getTransactions().get(transNum - 1).setAmount(newTransValue);
                                budget.setRemainingBudget(budget.getRemainingBudget() + oldAmount - newTransValue);
                                System.out.printf("The transaction's value has been successfully updated to %.2f", newTransValue);
                            }
                            else if (transNumOption == 2) {
                                // Option to delete a transaction
                                // Refund the transaction amount to the remaining budget
                                budget.setRemainingBudget(budget.getRemainingBudget() + budget.getTransactions().get(transNum - 1).getAmount());
                                budget.getTransactions().remove(transNum - 1);
                                System.out.println("Transaction has been deleted successfully.");
                            }
                            else {
                                System.out.println("Please enter a valid choice.");
                            }
                        }
                        else {
                            System.out.println("Please enter a valid transaction number.");
                        }
                    }

                    break;
                case (7):
                    // Option 7: Reset options for the budget and transactions
                    if (!budget.isBudgetSet()) {
                        break;
                    }

                    System.out.println("Do you want to reset: ");
                    System.out.println("1. Only the budget");
                    System.out.println("2. Only the transactions (including categories)");
                    System.out.println("3. Both budget & transactions (including categories)");
                    System.out.println("4. Leave it as it is");
                    System.out.print("Enter a choice: ");
                    int resetChoice = scnr.nextInt();
                    scnr.nextLine();

                    // Handle user input with switch-case statements
                    switch (resetChoice) {
                        case 1:
                            // Reset total budget back to zero
                            budget.setTotalBudget(0);
                            System.out.println("Total budget has been reset to zero successfully.");
                            break;
                        case 2:
                            // Reset transactions and categories while keeping the total budget
                            budget.getTransactions().clear();
                            budget.getCategories().clear();
                            budget.setRemainingBudget(budget.getTotalBudget());
                            System.out.println("All transactions and categories have been cleared successfully.");
                            break;
                        case 3:
                            // Reset everything: budget, transactions, categories (fresh start)
                            budget.setTotalBudget(0);
                            budget.getTransactions().clear();
                            budget.getCategories().clear();
                            System.out.println("Total budget, transactions, and categories cleared successfully.");
                            break;
                        case 4:
                            System.out.println("No changes made.");
                            break;
                        default:
                            System.out.println("Invalid choice. No changes made.");

                    }
                    break;
                case (8):
                    // Exit the program and save the data before exiting to load for next program run
                    budget.saveData("budgetTrackerData");
                    System.out.println("See you later!");
                    return;
                default:
                    System.out.println("Please enter a valid menu choice.");
            }
        }
    }
}