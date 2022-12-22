package com.glady.gladyTest.service;

import com.glady.gladyTest.model.Deposit;
import com.glady.gladyTest.model.User;
import com.glady.gladyTest.repository.DepositRepository;
import com.glady.gladyTest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Lazy
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final DepositRepository depositRepository;
    private final UserRepository userRepository;

    public double calculateBalance(long idUser) throws Exception {
        Optional<User> user = userRepository.findById(idUser);
        if (!user.isPresent()) {
            throw new Exception(" user not found ");
        }
        List<Deposit> deposits = depositRepository.findByUserId(idUser);
        log.info("ddeposit : "+ deposits);
        double sum = deposits.stream().filter(dep -> dep.getAmount() > 0).mapToDouble(o -> o.getAmount()).sum();
        return sum;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public Optional<User> get(long user) {
        return userRepository.findById(user);
    }
}
