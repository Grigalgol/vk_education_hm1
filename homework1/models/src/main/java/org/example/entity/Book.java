package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Book {

    private int id;
    private String title;
    private Author author;
    private int countPages;
    private String genre;
    private int age;

}
