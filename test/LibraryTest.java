import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

    class LibraryTest {
        Library library;
        Person grace;

        @BeforeEach
        void setUp() {
            library = new Library();
            grace = new Person("Grace");
            library.addBook(new Book("Learn to code"));
            library.addBook(new Book("Clean code"));
        }

        @Test
        void testObj() {
            assertNotNull(library);
        }

        @Test
        void testLibraryBooks() {
            library.getBooks()
                    .forEach(x -> System.out.println(x.getName()));
        }

        @Test
        void checkBookExist() {
            boolean exist = false;
            for (Book b : library.getBooks()) {
                if (b.getName().equals("Learn to code")) {
                    exist = true;
                    break;
                }
            }
            assertTrue(exist);
        }

        @Test
        void checkBookAvailability() {
            String name = "Clean code";
            boolean available = false;
            for (Book book : library.getBooks()) {
                if (book.getName().equals(name)) {
                    if (book.isAvailable()) {
                        available = true;
                        break;
                    }
                }
            }
            assertTrue(available);
        }

        boolean bookAvailable (String name) {
            for (Book book : library.getBooks()) {
                if (book.getName().equals(name)) {
                    if (book.isAvailable()) {
                        return true;
                    }
                }
            }
            return false;
        }

        void showLibrary() {
            System.out.printf("%-16s  %-10s  isAvailable \n", "Name", "Reader");
            for (Book book : library.getBooks()) {
                System.out.printf("%-18s %-10s %-10s \n", book.getName(), book.getReader(), book.isAvailable());

            }
        }

        @Test
        void borrowBook() {
            String bookName = "Learn to code";
            grace.borrowBook(bookName, library.getBooks());
            grace.borrowBook("Clean code", library.getBooks());
            grace.getReadBooks()
                    .forEach(System.out::println);
        }

        @Test
        void testReturnBook() {
            boolean borrowed;
            library.addBook(new Book("Design Patterns"));
            borrowed = grace.borrowBook("Clean code", library.getBooks());
            assertTrue(borrowed);
            borrowed = grace.borrowBook("Design Patterns", library.getBooks());
            assertFalse(borrowed);
            showLibrary();
            assertTrue(grace.returnBook(library.getBooks()));
            System.out.println();
            showLibrary();
            System.out.println();
            grace.getReadBooks()
                    .forEach(System.out::println);
        }
    }
