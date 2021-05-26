package jwzp.security.spring_security_openid;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SecurityController {

    private final List<Book> booksList;

    public SecurityController() {
        booksList = new ArrayList<>();
        booksList.add(new Book("Krzyżacy", "Henryk Sienkiewicz", "GREG"));
        booksList.add(new Book("Hobbit", "John Ronald Reuel Tolkien", "Iskra"));
        booksList.add(new Book("Czterej pancerni i pies", "Janusz Przymanowski", "Vesper"));
    }

    //Dostęp bez uwierzytelnienia
    @GetMapping({ "/books"})
    public List<Book> getBooks() {
        return booksList;
    }

    //Dostęp z uwierzytelnieniem
    @GetMapping({ "/book"})
    public Book getBook() {
        return booksList.get(0);
    }

    @PostMapping("/books")
    public boolean addBook(@RequestBody Book book) {
        return booksList.add(book);
    }

    @DeleteMapping("/books")
    public void deleteBook(@RequestBody Book book) {
        booksList.remove(book);
    }
}
