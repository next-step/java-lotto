package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null_값을_입력할_경우_0을_반환한다(String inputString) {
        //given
        StringCalculator calculator = new StringCalculator();
        //when
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(0);
    }
}
