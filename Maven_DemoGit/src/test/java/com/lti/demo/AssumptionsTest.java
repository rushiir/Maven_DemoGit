package com.lti.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

//Additional support while executing
// a failed Assumption results in test being terminated
// when to use - if test case failed ...do not continue further
// 100 lines -- 10th error

class AssumptionsTest {

	@Test
    void testOnDev()
    {
        System.setProperty("ENV", "DEV");
        
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")),AssumptionsTest::message);
        
        System.out.println(" continue execution");
      
    }

    @Test
    void testOnProd()
    {
        System.setProperty("ENV", "PROD");
        Assumptions.assumeTrue("PROD".equals(System.getProperty("DEV")),AssumptionsTest::message);
        System.out.println(" don't continue execution");
    }

    private static String message () {
        return "TEST Execution Failed :: ";
    }
	
}
