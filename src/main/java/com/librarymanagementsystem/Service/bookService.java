package com.librarymanagementsystem.Service;

import com.librarymanagementsystem.Dto.Response.genericResponse;
import com.librarymanagementsystem.Model.Book;
import com.librarymanagementsystem.repo.bookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class bookService {

    private final bookRepository bookRepository;

    public genericResponse getallbook(){
        List<Book> getallbooks = bookRepository.findAll();
        return new genericResponse("00",
                "THIS ARE ALL THE BOOKS",
                getallbooks,
                null
        );
    }
    public genericResponse getBookByIsbnnumber(long isbnNumber){
       var exist = bookRepository.findByIsbnNumber(isbnNumber);
       if (exist != null){
           return new genericResponse("00",
                   "THIS IS THE BOOK",
                   exist,
                   null
           );
       }
       return new genericResponse("11",
               "DOES NOT EXIST",
               null,
               null
       );
    }
    public genericResponse addbook(Book request){
        var exist = bookRepository.findByIsbnNumber(request.getIsbnNumber());
        if (exist == null){
            Book book = new Book();
            book.setName(request.getName());
            book.setAuthor(request.getAuthor());
            book.setPublisher(request.getPublisher());
            book.setIsbnNumber(request.getIsbnNumber());

            bookRepository.save(book);

            return new genericResponse("00",
                    "ADDED SUCCESSFULLY",
                    book,
                    null
            );
        }
        return new genericResponse("11",
                "BOOK ALREADY EXIST",
                null,
                null
        );
    }
    public genericResponse deleteAllBooks(){
        var exist = bookRepository.findAll();
        if (exist.isEmpty()){
            return new genericResponse("11",
                    "THE LIBRARY IS EMPTY",
                    null,
                    null
            );
        }
        bookRepository.deleteAll();
        return new genericResponse("00",
                "SUCCESSFULLY DELETED",
                exist,
                null
        );
    }
    public genericResponse deleteByIsbnNumber(long isbnNumber){
        var exist = bookRepository.findByIsbnNumber(isbnNumber);
        if (exist != null){
             bookRepository.delete(exist);

             return new genericResponse("00",
                     "DELETED SUCCESSFULLY",
                     exist,
                     null
             );
        }
        return new genericResponse("11",
                "BOOK DOES NOT EXIST",
                null,
                null
        );
    }
    public genericResponse updateBookByIsbnNumber(long isbnNumber , Book request){
        var exist = bookRepository.findByIsbnNumber(isbnNumber);
        if (exist != null){
            exist.setName(request.getName());
            exist.setAuthor(request.getAuthor());
            exist.setPublisher(request.getPublisher());
            exist.setIsbnNumber(request.getIsbnNumber());

            bookRepository.save(exist);

            return new genericResponse("00",
                    "UPDATED SUCCESSFULLY",
                    exist,
                    null
            );
        }
        return new genericResponse("11",
                "BOOK DOES NOT EXIST",
                null,
                null);
    }
}
