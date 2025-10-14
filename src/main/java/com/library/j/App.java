package com.library.j;
import com.library.model.Book;
import com.library.service.LibraryService;

public class App {
    public static void main(String[] args) {
        LibraryService s = new LibraryService();
        s.addBook(new Book("B001","Clean Code","Robert Martin"));
        s.addBook(new Book("B002","Java Complete Reference","Herbert Schildt"));
        s.checkout("B001");

        System.out.println("Library Books:");
        s.listBooks().forEach(b ->
            System.out.println(b.getId()+" | "+b.getTitle()+" | available="+b.isAvailable())
        );
    }
}
