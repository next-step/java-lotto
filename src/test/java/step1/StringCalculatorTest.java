package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null_값을_입력할_경우_0을_반환한다(String inputString) {
        //Given
        //When
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"-1,-1", "0,0", "1,1"})
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다(String inputString, int expectedResult) {
        //Given
        //When
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(expectedResult);
    }

    @Test
    void 숫자_두개를_컴마_구분자로_입력할_경우_두_숫자의_합을_반환한다() {
        //Given
        String inputString = "-1,2";
        //When
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(1);
    }

    @Test
    void 구분자를_컴마_이외에_콜론을_사용_가능하다() {
        //Given
        String inputString = "-1:2,3";
        //When
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(4);
    }

    @Test
    void 커스텀_구분자를_지정할_수_있다() {
        //Given
        String inputString = "//;\n1;2;3";
        //When
        //Then
        assertThat(calculator.calculate(inputString)).isEqualTo(6);

    }
}
