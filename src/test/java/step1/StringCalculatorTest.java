package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "2", "3"})
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다(String inputString) {
        //given
        StringCalculator calculator = new StringCalculator();
        //when
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(Integer.parseInt(inputString));
    }
}
