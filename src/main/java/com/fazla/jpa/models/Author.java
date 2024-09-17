package com.fazla.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data // This provides getter(), setter(), toString(), hashCode(), Equals, constructor with final fields
@NoArgsConstructor
@Entity  // This tells to create Author Entity in the Database
//@Table(name = "AUTHOR_TBL")
public class Author {
    @Id
    @GeneratedValue
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
    private Integer id;
//    @Column(
//            name = "f_name",
//            length = 50
//    )
    private String firstName;
    private String lastName;

//    @Column(
//            unique = true,
//            nullable = false
//    )
    private String email;
    private int age;
//    @Column(
//            updatable = false,
//            nullable = false
//    )
//    private LocalDateTime createdAt;
//
//    @Column(insertable = false)
//    private LocalDateTime lastModifiedAt;
}
