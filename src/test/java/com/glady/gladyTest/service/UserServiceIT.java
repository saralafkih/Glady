package com.glady.gladyTest.service;

import com.glady.gladyTest.model.Deposit;
import com.glady.gladyTest.model.User;
import com.glady.gladyTest.repository.DepositRepository;
import com.glady.gladyTest.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceIT {
    @Mock
    private DepositRepository depositRepository;
    @Mock
    private UserRepository userRepository;

    private UserService service;

    @BeforeEach
    void setUp() {
        service = new UserService(depositRepository, userRepository);
    }

    @Test
    void saveUser_test() {
        Mockito.doNothing().when(userRepository).save(Mockito.any(User.class));
        User result = service.saveUser(Mockito.any(User.class));
        Assertions.assertNotNull(result);
    }

    @Test
    void calculateBalance_test() throws Exception {
        when(depositRepository.findByUserId(any(Long.class))).thenReturn(Arrays.asList(Deposit.builder()
                .user(User.builder().idUser(1).name("name1").build())
                .dateDeposit(new Date()).amount(100L).build()));
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(User.builder().idUser(1).name("name1").build()));
        Double result = service.calculateBalance(Mockito.any(Long.class));
        Assertions.assertNotNull(result);
        Assertions.assertEquals(100L,result.doubleValue());
    }
}
