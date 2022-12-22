package com.glady.gladyTest.controller;

import com.glady.gladyTest.model.User;
import com.glady.gladyTest.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/balance")
    public ResponseEntity<Double> getUserBalance(@RequestParam(value = "idUser") long idUser) throws Exception {
        return new ResponseEntity<>(userService.calculateBalance(idUser), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@Validated @RequestBody User user) throws Exception {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
}
