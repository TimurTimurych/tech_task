package com.ifortex.bookservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

// Attention! It is FORBIDDEN to make any changes in this file!
@Entity
@Table(name = "books")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String description;
  private String author;

  @Column(name = "publication_date")
  private LocalDateTime publicationDate;

  @Column(name = "genre")
  private Set<String> genres;
}
