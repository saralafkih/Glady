package com.glady.gladyTest.service;

import com.glady.gladyTest.model.Company;
import com.glady.gladyTest.model.Deposit;
import com.glady.gladyTest.model.User;
import com.glady.gladyTest.repository.CompanyRepository;
import com.glady.gladyTest.repository.DepositRepository;
import com.glady.gladyTest.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceIT {
    @Mock
    private DepositRepository depositRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CompanyRepository companyRepository;
    private CompanyService service;

    @BeforeEach
    void setUp() {
        service = new CompanyService(companyRepository, depositRepository, userRepository);
    }

    @Test
    void saveCompany_test() {
        Mockito.doNothing().when(companyRepository).save(Mockito.any(Company.class));
        Company result = service.saveCompany(Mockito.any(Company.class));
        Assertions.assertNotNull(result);
    }

    @Test
    void distribute_test() throws ParseException {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(User.builder().idUser(1).name("name1").build()));
        when(companyRepository.findById(any(Long.class))).thenReturn(Optional.of(Company.builder().idCompany(1L).balance(200).name("company1").build()));
        String result = service.distribute(1L, 1L, "GIFT", 20);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("done !", result);
    }
}
