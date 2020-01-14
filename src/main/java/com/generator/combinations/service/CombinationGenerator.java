package com.generator.combinations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CombinationGenerator {

    private static final Logger logger = LoggerFactory.getLogger(CombinationGenerator.class);

    public int generate(int noOfBalls){

        logger.info("Generating combinations for {}",noOfBalls);

        int n = noOfBalls-1;

        if(n==0){
            return 1;
        }

        int combinations = 0;

        //The following can be variable
        int arr[] = {1,2};
        int m = arr.length;

        while(n > 0){
            combinations += count(arr, m, n--);
        }
        logger.info("Result: {}",combinations);

        return combinations;
    }

    /**
     *The following method was copied from https://www.geeksforgeeks.org/coin-change-dp-7/
     */
    private int count( int S[], int m, int n )
    {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        int table[]=new int[n+1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i<m; i++)
            for(int j=S[i]; j<=n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }

}
