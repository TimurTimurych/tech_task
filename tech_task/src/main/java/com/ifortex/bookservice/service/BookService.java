package com.ifortex.bookservice.service;

import com.ifortex.bookservice.dto.SearchCriteria;
import com.ifortex.bookservice.model.Book;

import java.util.List;
import java.util.Map;

// Attention! It is FORBIDDEN to make any changes in this file!
public interface BookService {
  /**
   * Retrieves the total count of {@link Book}s for each genre, ordered from the genre with the most
   * books to the least
   *
   * @return desired result as a Map where key is book genre and value is count of the books
   */
  Map<String, Long> getBooks();

  /**
   * Returns {@link Book}s that will match with passed {@link SearchCriteria} sorted by {@link
   * Book#publicationDate}
   *
   * @param searchCriteria book search criteria
   * @return list of the books
   */
  List<Book> getAllByCriteria(SearchCriteria searchCriteria);
}
