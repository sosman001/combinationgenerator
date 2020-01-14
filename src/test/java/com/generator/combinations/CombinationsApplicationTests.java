package com.generator.combinations;

import com.generator.combinations.service.CombinationGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CombinationsApplicationTests {

    @Autowired
    private CombinationGenerator combinationGenerator;

    @Test
    public void whenNoOfBallsIsThree_ThenReturnThree(){
        Assert.assertEquals(combinationGenerator.generate(3),3);
     }

    @Test
    public void whenNoOfBallsIsFive_ThenReturnEight(){
        Assert.assertEquals(combinationGenerator.generate(5),8);
    }
}
