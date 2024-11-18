package com.ifortex.bookservice.service.impl;

import com.ifortex.bookservice.dto.SearchCriteria;
import com.ifortex.bookservice.model.Book;
import com.ifortex.bookservice.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

// Attention! It is FORBIDDEN to make any changes in this file!
@Service
public class ESBookServiceImpl implements BookService {

  @Override
  public Map<String, Long> getBooks() {
    // will be implemented shortly
    return Map.of();
  }

  @Override
  public List<Book> getAllByCriteria(SearchCriteria searchCriteria) {
    // will be implemented shortly
    return List.of();
  }
}
