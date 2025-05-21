package com.fdxsoft.JPAPostgreSQL.domain;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import lombok.*;

/*
 * Ojo: para que me genere en automatico el ID de esta tabla a la hora de hacer INSERT
 * y no tener que hacer lo siguiente:
 * 		INSERT INTO public.e_user (id, user_name, password)
 * 		VALUES (nextval('user_id_seq'), 'federico','password');
 * Es necesario ejcutar este otro comando:
 * 		ALTER TABLE public.e_user
 * 		ALTER COLUMN id SET DEFAULT nextval('user_id_seq');
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="e_client")
public class ClientEntity {
    @Id
    @SequenceGenerator(name = "client_id_seq",
            sequenceName = "client_id_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "client_id_seq")
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(length = 40)
    private String lastName;
    
    //OJO: SI no uso el mappedBy, se genera una tabla extra intermedia que no sirve para nada
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_client_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<AddressEntity> addresses = new HashSet<AddressEntity>();
    
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "client_product", 
    		   joinColumns = {@JoinColumn(name="fk_client_id")},
    		   inverseJoinColumns = {@JoinColumn(name="fk_product_id")})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ProductEntity> products = new HashSet<ProductEntity>();
    
    
}
