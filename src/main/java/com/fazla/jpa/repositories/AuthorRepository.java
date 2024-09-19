package com.fazla.jpa.repositories;

import com.fazla.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    @Transactional
    List<Author> findByNamedQuery(@Param("age") int id);

    @Transactional
    @Modifying
    void updateByNamedQuery(@Param("age") int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age=:age where a.id=:id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age=:age")
    void updateAllAuthorsAges(int age);

    //select * from author where first_name = 'ali'
    List<Author> findAllByFirstName(String firstName);

    //select * from author where first_name = 'al'
    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    //select * from author where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    //select * from author where first_name like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    //select * from author where first_name like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);

    //select * from author where first_name in ('ali', 'bou', 'coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
