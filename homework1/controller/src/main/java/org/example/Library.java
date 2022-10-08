package org.example;

import com.google.gson.Gson;
import org.example.entity.Book;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public String serializationLibraryByAuthorName(String authorName) {
        List<Book> booksByAuthor = books
                .stream()
                .filter(book -> book.getAuthor().getName().equals(authorName))
                .collect(Collectors.toList());
        Gson gson = new Gson();
        String json = gson.toJson(booksByAuthor);
        return json;
    }

}
