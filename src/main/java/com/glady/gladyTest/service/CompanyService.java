package com.glady.gladyTest.service;

import com.glady.gladyTest.model.Company;
import com.glady.gladyTest.model.Deposit;
import com.glady.gladyTest.model.User;
import com.glady.gladyTest.repository.CompanyRepository;
import com.glady.gladyTest.repository.DepositRepository;
import com.glady.gladyTest.repository.UserRepository;
import com.glady.gladyTest.utility.Utility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

@Lazy
@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final DepositRepository depositRepository;
    private final UserRepository userRepository;

    public String distribute(long idUser, Long idCompany, String type, double amount) throws ParseException {
        String returnedMessage = "";
        Optional<User> user = userRepository.findById(idUser);
        Optional<Company> company = companyRepository.findById(idCompany);
        if (!user.isPresent() || !company.isPresent()) {
            returnedMessage = "user or company not found";
        }
        if (company.get().getBalance() >= amount) {
            depositRepository.save(Deposit.builder().company(company.get()).user(user.get()).
                    dateDeposit(new Date()).type(type).endDate(Utility.calculateEndDate(type, new Date())).amount(amount).build());
            returnedMessage = "done !";
        } else {
            returnedMessage = "balance of company is not suffisant";
        }
        return returnedMessage;
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }
}
