package stringAddCalculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    private Number testNumber;
    private int testInt;

    @BeforeEach
    void initializeTest(){
        testInt = 7;
        testNumber = new Number(testInt);
    }

    @Test
    @DisplayName("create Number Test")
    void createNumberTest(){
        assertThat(new Number(testInt)).isEqualTo(testNumber);
    }


    @Test
    @DisplayName("Number value method test")
    void valueMethodTest(){
        assertThat(new Number(testInt).value()).isEqualTo(testInt);
    }

}