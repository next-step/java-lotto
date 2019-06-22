package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null_값을_입력할_경우_0을_반환한다(String inputString) {
        //given
        //when
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"-1,-1", "0,0", "1,1"})
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다(String inputString, int expectedResult) {
        //given
        //when
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(expectedResult);
    }

    @Test
    void 숫자_두개를_컴마_구분자로_입력할_경우_두_숫자의_합을_반환한다() {
        //given
        String inputString = "-1,2";
        //when
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(1);
    }
}
