package stringaddcalculater;

import org.junit.jupiter.api.Test;

import stringaddcalculator.calculator.StringAddCalculator;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculaterTest {

    StringAddCalculator stringaddcalculater;

    @Test
    void operatorTest(){

    }

    @Test
    void sortValueTest(){
        String value = "1,2,3";
        String[] result = stringaddcalculater.sortValue(value);
        assertThat(result.length).isEqualTo(5);
    }
    
}