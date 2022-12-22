package com.glady.gladyTest.repository;

import com.glady.gladyTest.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
    @Query("SELECT p FROM Deposit p WHERE p.user.idUser = :idUser")
    List<Deposit> findByUserId(long idUser);

    @Query("SELECT p FROM Deposit p WHERE p.user.idUser = :idUser")
    double calculateAmount(long idUser);
}
