package books;

public class Book {
    private String author;
    private String title;
    private int pages;
    private BookType type;

    public Book(String author, String title, int pages, BookType type) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.type = type;
    }

    public int daysForReturn() {
        return type.daysForReturn();
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public static Book parseBook(String bookStr) {
        String[] s = bookStr.split(";");
        String author = s[0];
        String title = s[1];
        int pages = Integer.parseInt(s[2]);
        BookType type = BookType.of(s[3]);
        return new Book(author, title, pages, type);
}
}
