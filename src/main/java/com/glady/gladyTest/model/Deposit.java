package com.glady.gladyTest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Deposit {

    @Id
    @Column(name = "id_deposit", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDeposit;
    @Column(name = "type",  nullable = false)
    private String type;
    @Column(name = "date_deposit",  nullable = false)
    private Date dateDeposit;
    @Column(name = "end_date",  nullable = false)
    private Date endDate;
    @Column(name = "amount", nullable = false)
    private double amount;
    @ToString.Exclude
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;
    @ToString.Exclude
    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    private Company company;

}
