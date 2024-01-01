package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    List<Book> bookDB=new ArrayList<>();
    public BookRepository(){
        
    }

    public Book save(Book book){
        bookDB.add(book);
        return book;
    }

    public Book findBookById(int id){
        for(Book book:bookDB){
            if(id==book.getId()){
                return book;
            }
        }
        return null;
    }

    public List<Book> findAll(){
        return bookDB;
    }

    public void deleteBookById(int id){
        for (Book book:bookDB){
            if(id== book.getId()){
                bookDB.remove(book);
            }
        }
        return;
    }

    public void deleteAll(){
        bookDB.removeAll(bookDB);
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> bookList=new ArrayList<>();
        for (Book book:bookDB){
            if(author.equals(book.getAuthor())){
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> bookList=new ArrayList<>();
        for (Book book:bookDB){
            if(genre.equals(book.getGenre())){
                bookList.add(book);
            }
        }
        return bookList;
    }
}
