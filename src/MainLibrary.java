public class MainLibrary {
        public static void main(String... args){
            Library library = new Library();
            Book book = new Book();
            Person person = new Person("Grace");
            library.addBook(new Book("Learn to code"));
            library.addBook(new Book("Clean code"));
            library.addBook(new Book("Design patterns"));

            System.out.println("Books currently in the library");
            library.getBooks()
                    .forEach(x -> System.out.println(x.getName()));
            System.out.println();

            person.borrowBook("Clean code", library.getBooks());
            System.out.println("After borrowing");
            library.showLibrary();
            System.out.println();

            person.returnBook(library.getBooks());
            System.out.println("After returning");
            library.showLibrary();


        }
    }



