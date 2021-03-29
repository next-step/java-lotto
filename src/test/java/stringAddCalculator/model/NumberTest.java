package stringAddCalculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {

    private Number testNumber;
    private int testNegertive;
    private String testString;
    private int testInt;

    @BeforeEach
    void initializeTest(){
        testInt = 7;
        testNegertive = -1;
        testString = "7";
        testNumber = new Number(testInt);
    }

    @Test
    @DisplayName("create Number Test")
    void createNumberTest(){
        assertThat(new Number(testInt)).isEqualTo(testNumber);
    }

    @Test
    @DisplayName("create Number by String value Test")
    void createNumberByStringTest(){
        assertThat(new Number(testString)).isEqualTo(testNumber);
    }

    @Test
    @DisplayName("create Number by negative NumberTest")
    void negativeNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(testNegertive));
    }


    @Test
    @DisplayName("Number value method test")
    void valueMethodTest(){
        assertThat(new Number(testInt).value()).isEqualTo(testInt);
    }

}