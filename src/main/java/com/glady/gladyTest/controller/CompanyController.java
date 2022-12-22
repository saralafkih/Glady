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
    public ResponseEntity<Company> save(@Validated @RequestBody Company company) throws Exception {
        return new ResponseEntity<>(companyService.saveCompany(company), HttpStatus.OK);
    }
    @GetMapping("/hello")
    public ResponseEntity<String> aa() throws Exception {
        return new ResponseEntity<>("companyService.distribute(idUser, companyId, type, amount)", HttpStatus.OK);
    }
}
