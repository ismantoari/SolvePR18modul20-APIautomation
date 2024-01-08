package StepDef;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;

import io.cucumber.java.*;

public class Hooks {

    @BeforeAll
    public static void setUp(){
        System.out.println("BeforeAll");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("AfterAll");
    }

    @Before
    public void beforeTest(){
        System.out.println("BeforeTest");
    }

    @After
    public void afterTest(){
        System.out.println("AfterTest");
    }
}
