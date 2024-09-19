package com.fazla.jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder
@Data // This provides getter(), setter(), toString(), hashCode(), Equals, constructor with final fields
@NoArgsConstructor
@Entity  // This tells to create Author Entity in the Database
//@Table(name = "AUTHOR_TBL")
//@NamedQuery(
//        name = "Author.findByNamedQuery",
//        query = "select a from Author a where a.age>=:age"
//)
//@NamedQuery(
//        name = "Author.updateByNamedQuery",
//        query = "update Author a set a.age=:age"
//)

@NamedQueries(
        {
                @NamedQuery(
                        name = "Author.findByNamedQuery",
                        query = "select a from Author a where a.age>=:age"
                ),
                @NamedQuery(
                        name = "Author.updateByNamedQuery",
                        query = "update Author a set a.age=:age"
                )
        }
)
public class Author extends BaseEntity{
//    @Id
//    @GeneratedValue
    // Table Generation generation
            /*(
                    strategy = GenerationType.TABLE,
                    generator = "author_id_gen"
            )
    @TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value"
    )*/

    // Sequence Number generation
            /*(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence" // Here just pointing that id will be generated from author_sequence table
            // The author_sequence table is created by the @SequenceGenerator table --> below
    )
    @SequenceGenerator ( // Creates a custom sequence table named author_sequence
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1,
            initialValue = 150
    )*/
//    private Integer id;
//    @Column(
//            name = "f_name",
//            length = 50
//    )
    private String firstName;
    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;


    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Course> courses;

//    @Column(
//            updatable = false,
//            nullable = false
//    )
//    private LocalDateTime createdAt;
//
//    @Column(insertable = false)
//    private LocalDateTime lastModifiedAt;
}
