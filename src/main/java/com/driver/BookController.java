package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }


    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id")int id){
        Book book=bookService.findBookById(Integer.toString(id));
        return new ResponseEntity<>(book,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> bookList=bookService.findAllBooks();
        return new ResponseEntity<>(bookList,HttpStatus.FOUND);
    }


    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam("author")String author){
        List<Book> bookList=bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(bookList,HttpStatus.ACCEPTED);
    }


    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam("genre")String genre){
        List<Book> bookList=bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(bookList,HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") int id){
        bookService.deleteBookById(Integer.toString(id));
        String msg= "book is deleted sucessfully";
        return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteBookById(){
        bookService.deleteAllBooks();
        String msg= "all books are deleted sucessfully";
        return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
    }
}
