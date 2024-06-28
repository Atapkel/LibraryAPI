package library.com.LibraryApp.controller;

import library.com.LibraryApp.model.Book;
import library.com.LibraryApp.services.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return bookService.findById(id);
    }
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteById(id);
    }

    @PostMapping("/{userId}/borrow/{bookId}")
    public ResponseEntity<Book> borrowBook(@PathVariable int userId, @PathVariable int bookId){
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null){
            return ResponseEntity.ok(borrowedBook);
        }else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/{bookId}/returnBook")
    public ResponseEntity<Book> returnBook(@PathVariable int bookId){
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null)
            return ResponseEntity.ok(returnedBook);
        else return ResponseEntity.badRequest().build();
    }
}
