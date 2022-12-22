package com.glady.gladyTest.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "utilisateur")
public class User {

    @Id
    @Column(name = "id_user", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Deposit> deposit;

}
