package com.librarymanagementsystem.Controller;

import com.librarymanagementsystem.Dto.Response.genericResponse;
import com.librarymanagementsystem.Model.Book;
import com.librarymanagementsystem.Service.bookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/book")
public class bookController {

    public final bookService bookService;

    @GetMapping
    public ResponseEntity<genericResponse> getallbooks(){
        genericResponse response = bookService.getallbook();
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @GetMapping("{getbyisbnnumber}")
    public ResponseEntity<genericResponse> getbookbyisbnnumber(@PathVariable("getbyisbnnumber") long isbnNumber){
        genericResponse response = bookService.getBookByIsbnnumber(isbnNumber);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<genericResponse> addbook(@RequestBody Book request){
        genericResponse response = bookService.addbook(request);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<genericResponse> deleteallbooks(){
        genericResponse response = bookService.deleteAllBooks();
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @DeleteMapping("{deleteByIsbnnumber}")
    public ResponseEntity<genericResponse> deleteByIsbnNumber(@PathVariable("deleteByIsbnnumber") long isbnNumber){
        genericResponse response = bookService.deleteByIsbnNumber(isbnNumber);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @PutMapping("{updatebyisbnNumber}")
    public ResponseEntity<genericResponse> updateByIsbnNumber(@PathVariable("updatebyisbnNumber") long isbnNumber , @RequestBody Book request){
        genericResponse response = bookService.updateBookByIsbnNumber(isbnNumber, request);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
