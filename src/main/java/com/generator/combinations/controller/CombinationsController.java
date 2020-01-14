package com.generator.combinations.controller;

import com.generator.combinations.service.CombinationGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class CombinationsController {

    private static final Logger logger = LoggerFactory.getLogger(CombinationsController.class);

    @Autowired
    private CombinationGenerator combinationGenerator;

    @GetMapping(value="/{noOfBalls}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCombinations(@PathVariable int noOfBalls){

        logger.info("GET combinations input {}",noOfBalls);

        if(noOfBalls < 1){
            return ResponseEntity.badRequest().build();
        }

        int combinations = combinationGenerator.generate(noOfBalls);

        return ResponseEntity.ok(Collections.singletonMap("combinations",combinations));
    }
}
