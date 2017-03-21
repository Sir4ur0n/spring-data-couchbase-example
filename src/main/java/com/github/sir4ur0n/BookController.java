package com.github.sir4ur0n;

import java.util.Collection;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julien Debon
 */
@RestController
public class BookController {

  private BookRepository bookRepository;

@Autowired
  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping("/book/add")
  Book add(@RequestParam String bookName) {
    Book book = new Book();
    book.setId(UUID.randomUUID());
    book.setName(bookName);
    return bookRepository.save(book);
  }

  @GetMapping("/book/deleteWithDerivation")
  Collection<Book> deleteWithDerivation(@RequestParam String bookName) {
    return bookRepository.deleteByName(bookName);
  }

  @GetMapping("/book/deleteWithN1QL")
  Collection<Book> deleteWithN1QL(@RequestParam String bookName) {
    return bookRepository.deleteByNameWithN1QL(bookName);
  }
}
