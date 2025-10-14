package com.library.service;
import com.library.model.Book;
import java.util.*;

public class LibraryService {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book b){ books.put(b.getId(), b); }

    public Book getBook(String id){ return books.get(id); }

    public Collection<Book> listBooks(){
        return books.values();
    }

    public boolean checkout(String id){
        Book b = books.get(id);
        if (b == null || !b.isAvailable()) return false;
        b.setAvailable(false);
        return true;
    }

    public boolean checkin(String id){
        Book b = books.get(id);
        if (b == null || b.isAvailable()) return false;
        b.setAvailable(true);
        return true;
    }
}
