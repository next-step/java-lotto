package stringaddcalculater;

import org.junit.jupiter.api.Test;

import stringaddcalculator.calculator.StringAddCalculator;
import stringaddcalculator.domain.Separator;
import stringaddcalculator.view.InputView;
import stringaddcalculator.view.ResultView;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculaterTest {

    StringAddCalculator stringaddcalculater = new StringAddCalculator(new InputView(), new ResultView());

    @Test
    void operatorTest(){

    }

    @Test
    void sortValueTest(){
        Separator separator = new Separator();
        String value = "1,2,3";
        String[] result = stringaddcalculater.sortValue(value, separator);
        assertThat(result.length).isEqualTo(5);
    }
    
}