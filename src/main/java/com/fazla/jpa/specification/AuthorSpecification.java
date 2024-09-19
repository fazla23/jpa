package com.fazla.jpa.specification;

import com.fazla.jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {
    public static Specification<Author> authorSpecification(int age) {
        return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder builder ) -> {
            if(age < 0)
                return null;
            return builder.equal(root.get("age"),age);
        };
    }

    public static Specification<Author> firstNameLike(String firstname) {
        return (Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder ) -> {
                    if(firstname == null)
                        return null;
                    return builder.like(root.get("firstname"),firstname);
                };
    }
}
