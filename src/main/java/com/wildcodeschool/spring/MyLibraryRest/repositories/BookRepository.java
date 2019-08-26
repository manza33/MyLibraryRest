package com.wildcodeschool.spring.MyLibraryRest.repositories;

import com.wildcodeschool.spring.MyLibraryRest.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitleContainingOrAuthorContainingOrDescriptionContaining(String textOne, String textTwo, String textThree);

}
