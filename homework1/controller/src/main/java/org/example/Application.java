package org.example;

import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(@NotNull String[] args) {
        System.out.println(LibraryFactory.library.serializationLibraryByAuthorName(args[0]));
    }
}