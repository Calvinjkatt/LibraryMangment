package project;

public interface User {
    String email = null;
    String password = null;
    UserType type = null;
    boolean loggedIn = false;
    PaymentManager balance = null;
    SystemDirectory directory = null;

    void login(String email, String password);
    void logout();
    void rentItem(PhysicalItem physical);
    void viewBorrowedItems();
    void returnItem(PhysicalItem physical);
    void purchaseItem(PhysicalItem physical);
    PaymentManager getBalance();
    void subscribeToNewsLetter();
    void unsubscribeFromNewsletter();
}
