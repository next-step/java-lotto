package stringAddCalculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    private Numbers numbers;
    private Number numberA;
    private Number numberB;
    private Number numberC;

    @BeforeEach
    void initializeNumbersTest() {
        numberA = new Number(9);
        numberB = new Number(2);
        numberC = new Number(0);

        List<Number> numberList = Arrays.asList(numberA, numberB, numberC);
        numbers = new Numbers(numberList);
    }


    @Test
    @DisplayName("create Numbers Test")
    void createNumberTest(){
        assertThat(Arrays.asList(numberA, numberB, numberC)).contains(numberA,numberB,numberC);
    }


    @Test
    @DisplayName("adding Numbers Test")
    void getAddingResult() {
        assertThat(numbers.getAddingResult()).isEqualTo(11);
    }
}