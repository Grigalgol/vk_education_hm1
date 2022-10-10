package org.example;

import org.example.entity.Author;
import org.example.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryFactory {

    public static Library library = getLibrary();

    private static final String URL = "jdbc:postgresql://localhost:5432/homework1";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Library getLibrary() {
        List<Book> books = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            String SQL = "SELECT * FROM book JOIN author ON (book.author_id = author.id);";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();

                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setCountPages(resultSet.getInt("count_pages"));
                book.setGenre(resultSet.getString("genre"));
                book.setAge(resultSet.getInt("age"));
                author.setId(resultSet.getInt("author_id"));
                author.setName(resultSet.getString("name"));
                book.setAuthor(author);

                books.add(book);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Library(books);
    }


}
