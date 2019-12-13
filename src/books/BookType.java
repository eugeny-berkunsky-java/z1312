package books;

public interface BookType {
    BookType NEW = ()->3;
    BookType CHILD = ()->30;
    BookType REGULAR = ()->15;

    int daysForReturn();

    static BookType of(String type) {
        switch (type.toLowerCase()) {
            case "new" : return NEW;
            case "child" : return CHILD;
            default: return REGULAR;
        }
    }

    static BookType parseBook(String type) {
        return of(type);
    }
}
