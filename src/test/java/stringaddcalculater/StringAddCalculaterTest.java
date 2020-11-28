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
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    void removeSeparatorTest(){
        Separator separator = new Separator();
        String value = "1,2,3";
        String result[] = stringaddcalculater.removeSeparator(value, separator);
        assertThat(result[1]).isEqualTo("2");
    }

    @Test
    void findCumstomSeparatorTest(){
        Separator separator = new Separator();
        String value = "//;\\n1,2,3";
        String[] result = stringaddcalculater.findCumstomSeparator(value, separator);
        assertThat(result.length).isEqualTo(3);
        assertThat(separator.getSeparator().size()).isEqualTo(3);
    }

    @Test
    void addSeparatorTest(){
        Separator separator = new Separator();
        String value = "//;\\n1,2,3";
        String result = stringaddcalculater.addSeparator(value, separator);
        assertThat(result.length()).isEqualTo(1);
        assertThat(result).isEqualTo(";");
        assertThat(separator.getSeparator().size()).isEqualTo(3);
    }
    
    @Test
    void validateValueTest(){
        String value = "a";
        assertThatThrownBy(()->{
            stringaddcalculater.validateDigitAndNegative(value);
        }).isInstanceOf(RuntimeException.class)
        .hasMessageContaining("This value is not correct, Please check your input values");
    }
}
