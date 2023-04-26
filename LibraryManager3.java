import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager3 {

    private ArrayList<Book> books;

    public LibraryManager3() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("Invalid index!");
            return;
        }
        books.remove(index);
        System.out.println("Book removed successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library!");
            return;
        }
        System.out.println("Books in the library:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i+1) + ". " + books.get(i));
        }
    }

    public static void main(String[] args) {
        LibraryManager3 libraryManager = new LibraryManager3();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\nLibrary Management System\n");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter book title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(title, author, isbn);
                    libraryManager.addBook(book);
                    break;
                case 2:
                    System.out.print("\nEnter index of book to remove: ");
                    int index = scanner.nextInt() - 1;
                    libraryManager.removeBook(index);
                    break;
                case 3:
                    libraryManager.displayBooks();
                    break;
                case 4:
                    System.out.println("\nExiting program...");
                    break;
                default:
                    System.out.println("\nInvalid choice!");
                    break;
            }
        } while (choice != 4);
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}