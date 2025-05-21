package com.fdxsoft.JPAPostgreSQL.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="e_user")
public class UserEntity {

    @SequenceGenerator(name = "user_id_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq")
    @Id
    private Long id;
    @Column(length = 20)
    private String userName;
    @Column(length = 100)
    private String password;

    @OneToOne()
    @JoinColumn(name = "fk_client_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    ClientEntity clientEntity;
}
