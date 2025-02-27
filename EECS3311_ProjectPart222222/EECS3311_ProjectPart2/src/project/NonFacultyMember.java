package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonFacultyMember implements User {
    public String email;
    public String password;
    public UserType type;

    private boolean loggedIn;
    private PaymentManager balance;
    SystemDirectory directory;

    protected NonFacultyMember(String email, String password, UserType type) {
        this.email = email;
        this.password = password;
        this.type = type;

        directory = new SystemDirectory();
        balance = new PaymentManager();
    }

    // Methods from the interface
    public void login(String email, String password) {
        if (loggedIn) {
            System.out.println("You are already logged in.");
            UserManager.validateUser(this);
            return;
        } else if (this.email.equals(email) && this.password.equals(password)) {
            System.out.println("You are now logged in.");
            loggedIn = true;
        } else if (!this.email.equals(email) && !this.password.equals(password)) {
            System.out.println("Your email and password were incorrect");
        } else if (!this.email.equals(email)) {
            System.out.println("Your email was invalid");
        } else {
            System.out.println("Your password was incorrect");
        }
    }

    public void logout() {
        System.out.println("You are now logged out.");
        loggedIn = false;
    }

    public void rentItem(PhysicalItem physical) {
        BorrowPhysical.borrowItem(directory, physical, this);
    }

    public void viewBorrowedItems() {
        ArrayList<PhysicalItem> rentedItems = directory.getPhysicalRented();
        if (rentedItems.isEmpty()) {
            System.out.println("You haven't borrowed any items.");
        } else {
            System.out.println("List of borrowed items:");
            for (PhysicalItem item : rentedItems) {
                System.out.println("Title: " + item.getTitle());
                System.out.println("Location: " + item.getLocation());
                System.out.println("Rent Date: " + item.getRentDate());
                System.out.println("Due Date: " + item.getDueDate());
                System.out.println("------------------------------------");
            }
        }
    }

    public void returnItem(PhysicalItem physical) {
        BorrowPhysical.returnItem(directory, physical, this);
    }

    public void purchaseItem(PhysicalItem physical) {
       
            PurchasePhysical.purchase(physical, this);
        
    }

    public PaymentManager getBalance() {
        return balance;
    }

    public void subscribeToNewsLetter() {
        if (loggedIn) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your email to subscribe to the newsletter:");
            String userEmail = scanner.nextLine();
            scanner.close();
            Subscription subscription = new Subscription(userEmail);
            subscription.subscribe();
            System.out.println("Subscription request sent successfully!");
        } else {
            System.out.println("You must be logged in to subscribe to the newsletter.");
        }
    }

    public void unsubscribeFromNewsletter() {
        if (loggedIn) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your email to subscribe to the newsletter:");
            String userEmail = scanner.nextLine();
            scanner.close();
            Subscription subscription = new Subscription(userEmail);
            subscription.unsubscribe();
            if (subscription.isSubscribed()) {
                subscription.accessNewYorkTimes();
            }
            System.out.println("Unsubscription request sent successfully");
        } else {
            System.out.println("You must be logged in to unsubscribe to the newsletter.");
        }
    }
    
    protected Book searchBook(String bookName, BookSearch bookSearch) {
        return bookSearch.searchBook(bookName);
    }
    
    protected List<Book> findSimilarBooks(Book book, BookSearch bookSearch) {
        return bookSearch.findSimilarBooks(book);
    }
    
}
