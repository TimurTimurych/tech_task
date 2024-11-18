package com.ifortex.bookservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// Attention! It is FORBIDDEN to make any changes in this file!
@Entity
@Table(name = "members")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Member {
  @Id private long id;
  private String name;

  @Column(name = "membership_date")
  private LocalDateTime membershipDate;

  @ManyToMany
  @JoinTable(
      name = "member_books",
      joinColumns = @JoinColumn(name = "member_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id"))
  private List<Book> borrowedBooks;
}
