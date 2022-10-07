package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {

    private int id;
    private String title;
    private int author_id;
    private int countPages;
    private String genre;
    private String age;

}
