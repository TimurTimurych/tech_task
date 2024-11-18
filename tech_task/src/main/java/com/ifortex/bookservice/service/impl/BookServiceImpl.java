package com.ifortex.bookservice.service.impl;

import com.ifortex.bookservice.dto.SearchCriteria;
import com.ifortex.bookservice.model.Book;
import com.ifortex.bookservice.service.BookService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Primary
@Service
public class BookServiceImpl implements BookService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Map<String, Long> getBooks() {
        List<Book> books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();

        Map<String, Long> genreCountMap = new HashMap<>();

        for (Book book : books) {
            for (String genre : book.getGenres()) {
                genreCountMap.put(genre, genreCountMap.getOrDefault(genre, 0L) + 1);
            }
        }

        //возвращаем по убыванию
        return genreCountMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue())) // Сортировка по убыванию
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, //если дубли оставляем первый
                        LinkedHashMap::new //linkedHashMap чтобы сохранить порядок
                ));
    }


    @Override
    public List<Book> getAllByCriteria(SearchCriteria searchCriteria) {
        StringBuilder sql = new StringBuilder("SELECT * FROM books WHERE 1=1");
        Map<String, Object> parameters = new HashMap<>();

        if (searchCriteria != null) { //проверяем не пустое ли тело запроса
            if (searchCriteria.getGenre() != null && !searchCriteria.getGenre().trim().isEmpty()) {
                sql.append(" AND :genre = ANY (genre)");
                parameters.put("genre", searchCriteria.getGenre());
            }

            if (searchCriteria.getTitle() != null && !searchCriteria.getTitle().trim().isEmpty()) {
                sql.append(" AND LOWER(title) LIKE :title");
                parameters.put("title", "%" + searchCriteria.getTitle().toLowerCase() + "%");
            }

            if (searchCriteria.getAuthor() != null && !searchCriteria.getAuthor().trim().isEmpty()) {
                sql.append(" AND LOWER(author) LIKE :author");
                parameters.put("author", "%" + searchCriteria.getAuthor().toLowerCase() + "%");
            }

            if (searchCriteria.getDescription() != null && !searchCriteria.getDescription().trim().isEmpty()) {
                sql.append(" AND LOWER(description) LIKE :description");
                parameters.put("description", "%" + searchCriteria.getDescription().toLowerCase() + "%");
            }

            if (searchCriteria.getYear() != null) {
                sql.append(" AND EXTRACT(YEAR FROM publication_date) = :year");
                parameters.put("year", searchCriteria.getYear());
            }
        }

        //сртируем по дате
        sql.append(" ORDER BY publication_date ASC");

        Query query = entityManager.createNativeQuery(sql.toString(), Book.class);

        //устанавливаем параметры
        parameters.forEach(query::setParameter);

        return query.getResultList();
    }
}
