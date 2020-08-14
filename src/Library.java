

import java.util.LinkedList;
import java.util.List;

public class Library {

    private LinkedList<Book> books = new LinkedList<Book>();

    public LinkedList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    void showLibrary() {
        System.out.printf("%-16s  %-10s  isAvailable \n", "Name", "Reader");
        for (Book book : getBooks()) {
            System.out.printf("%-18s %-10s %-10s \n", book.getName(), book.getReader(), book.isAvailable());

        }
    }

}
