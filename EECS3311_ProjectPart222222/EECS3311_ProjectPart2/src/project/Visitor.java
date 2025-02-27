package project;

import java.util.List;

public class Visitor implements User {
	
	public String email;
    public String password;
    public UserType type;

    private boolean loggedIn;
    private PaymentManager balance;
    SystemDirectory directory;
	protected Visitor(String email, String password, UserType type) {
	    this.email = email;
	    this.password = password;
	    this.type = type;
	    this.loggedIn = false;
	    this.balance = null;
	    this.directory = null;
	}

    @Override
    public void login(String email, String password) {
        // Method intentionally left blank for Visitor
    }

    @Override
    public void logout() {
        // Method intentionally left blank for Visitor
    }

    @Override
    public void rentItem(PhysicalItem physical) {
        // Method intentionally left blank for Visitor
    }

    @Override
    public void viewBorrowedItems() {
        // Method intentionally left blank for Visitor
    }

    @Override
    public void returnItem(PhysicalItem physical) {
        // Method intentionally left blank for Visitor
    }

    @Override
    public void purchaseItem(PhysicalItem physical) {
        // Method intentionally left blank for Visitor
    }

    @Override
    public PaymentManager getBalance() {
        // Method intentionally left blank for Visitor
        return null;
    }

    @Override
    public void subscribeToNewsLetter() {
        // Method intentionally left blank for Visitor
    }

    @Override
    public void unsubscribeFromNewsletter() {
        // Method intentionally left blank for Visitor
    }
    
    protected Book searchBook(String bookName, BookSearch bookSearch) {
        return bookSearch.searchBook(bookName);
    }
    
    protected List<Book> findSimilarBooks(Book book, BookSearch bookSearch) {
        return bookSearch.findSimilarBooks(book);
    }
    
}
