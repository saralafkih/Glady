package com.glady.gladyTest.controller;

import com.glady.gladyTest.model.User;
import com.glady.gladyTest.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping(path = "/save")
    public ResponseEntity<User> save(@RequestParam(value = "name") String same) {
        return new ResponseEntity<>(userService.saveUser(User.builder().name(same).build()), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Optional<User>> findById(@RequestParam(value = "idUser") long idUser) {
        return new ResponseEntity<>(userService.get(idUser), HttpStatus.OK);
    }
}
