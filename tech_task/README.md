Tech Task Requirements

Installed tools requirements:
Java 17,
Maven,
Any IDE,
Docker.

In the project, you will find a docker-compose package. Run docker compose up to start the services. During the first application startup, database migration will execute and populate the necessary data.

Overview

You are working on a book service platform and are required to implement two services: BookService and MemberService. Please note that certain classes have restrictions and cannot be edited.

Tasks:
* BookService Implementation.

Implement the BookService interface and place your implementation in the existing impl package (preserving the existing classes inside the service).
      Required Methods:
  1. Count books by genre.

    Implement a method that retrieves the total count of books for each genre, ordered from the genre with the most books to the least.
  2. Search books with filters. Implement a method that returns books matching the provided search criteria, sorted by publication date.

    The search should support partial matches for fields such as title, author, etc. If no parameters are passed or all parameters are blank, return all books.

    For example, searching by title for the word “Wonderland”(Alice’s Adventures in Wonderland) should return any book(s) that contains ‘Wonderland’ in its title.
    All text fields should support this type of partial matching, and all parameters can be used together. Note that the genre field should be passed in singular form.
* MemberService Implementation.

Implement the MemberService interface and place your implementation in the existing impl package (preserving the existing classes inside the service).
      Required Methods:
  1. Find the member with the oldest Romance book.

    Implement a method that finds and returns the member who has read the oldest “Romance” genre book and who was most recently registered on the platform.
  2. Find members registered in 2023 who haven’t read any books.

    Implement a method that finds and returns members who registered in 2023 but have not read any books.

