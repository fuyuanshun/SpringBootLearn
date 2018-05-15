package com.fys.repository;

import com.fys.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAllByAuthorName(String authorName);

    Book findBookByAuthorName(String authorName);
}
