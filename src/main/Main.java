package main;

import books.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        int m;
        while((m = menu())!=0) {
            switch (m) {
                case 1:
                    showAll();
                    break;
                case 2:
                    books = readBookFromFile("books.txt");
                    break;
            }
        }
    }

    private void showAll() {
        System.out.println("+---------------------+----------------------------------------------------+-------+------+");
        System.out.println("|       Author        |                        Title                       | pages | days |");
        System.out.println("+---------------------+----------------------------------------------------+-------+------+");
        for (Book book : books) {
            System.out.printf("|%-20s | %-50s | %5d | %4d |\n", book.getAuthor(), book.getTitle(), book.getPages(), book.daysForReturn());
        }
        System.out.println("+---------------------+----------------------------------------------------+-------+------+");
    }

    private int menu() {
        System.out.println("1. Show All");
        System.out.println("2. Read From File");
        System.out.println("3. Write To File");
        System.out.println("4. Add To List");
        System.out.println("0. Exit");
        return new Scanner(System.in).nextInt();
    }

    public List<Book> readBookFromFile(String filename) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            return reader.lines().map(Book::parseBook).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
}
