package com.ifortex.bookservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// Attention! It is FORBIDDEN to make any changes in this file!
@Getter
@Setter
@Builder
public class SearchCriteria {
  private String title;
  private String author;
  private String genre;
  private String description;
  private Integer year;
}
