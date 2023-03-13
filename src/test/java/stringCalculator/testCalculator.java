package stringCalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class testCalculator {
    @ParameterizedTest
    @CsvSource(value = {"1000:2:3,3", "100:4, 2"})
    void stringParse(String stringCalculator, int stringCount) {
        StringCalculator calculator =  new StringCalculator(stringCalculator);
        assertThat(calculator.parseString2()).isEqualTo(stringCount);
    }

    @Test
    void stringParse2() {
        StringCalculator calculator =  new StringCalculator("//,\n1000,2,3,3");
        assertThat(calculator.parseString2()).isEqualTo(4);
    }

    @Test
    void sumString () {
        StringCalculator calculator =  new StringCalculator("//,\n1000,2,3,3");
        assertThat(calculator.sum()).isEqualTo(1008);
    }

    @Test
    void checkNumber() {
        StringCalculator calculator =  new StringCalculator("//,\n1000A,2,3,3");
        assertThatThrownBy(RuntimeException.class, ()->{calculator.sum();});
     //   assertThat(calculator.sum()).isEqualTo(1008);
    }
}
