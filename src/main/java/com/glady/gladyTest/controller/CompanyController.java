package com.glady.gladyTest.controller;

import com.glady.gladyTest.model.Company;
import com.glady.gladyTest.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/distribute")
    public ResponseEntity<String> distribute(@RequestParam(value = "idUser") long idUser,
                                             @RequestParam(value = "companyId") long companyId,
                                             @RequestParam(value = "type") String type,
                                             @RequestParam(value = "amount") double amount) throws Exception {
        return new ResponseEntity<>(companyService.distribute(idUser, companyId, type, amount), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Company> save(@RequestParam(value = "name") String name, @RequestParam(value = "balance") double balance) {
        return new ResponseEntity<>(companyService.saveCompany(Company.builder().name(name).balance(balance).build()), HttpStatus.OK);
    }
}
