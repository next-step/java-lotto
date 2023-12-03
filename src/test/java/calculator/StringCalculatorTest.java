package calculator;

import calculator.domain.Divide;
import calculator.domain.Minus;
import calculator.domain.Multiply;
import calculator.domain.Plus;
import calculator.service.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    void 덧셈_테스트() {
        assertThat(new Plus().calculate(10, 5)).isEqualTo(15);
    }

    @Test
    void 뺄셈_테스트() {
        assertThat(new Minus().calculate(10, 5)).isEqualTo(5);
    }

    @Test
    void 곱셈_테스트() {
        assertThat(new Multiply().calculate(10, 5)).isEqualTo(50);
    }

    @Test
    void 나누기_테스트() {
        assertThat(new Divide().calculate(10, 5)).isEqualTo(2);
    }

    @DisplayName("입력된 문자열을 빈공백 기준으로 Split 기능 테스트")
    @Test
    void 문자열_빈공백_나누기_기능_테스트() {
        //given
        String stringCalculator = new String("1 + 2");

        //when
        String[] stringSplit = stringCalculator.split(" ");

        //then
        assertThat(stringSplit).hasSize(3);
    }

    @DisplayName("입력된 문자열의 첫번째가 기호 입력 시 예외발생 테스트")
    @Test
    void 문자열_첫번째_기호_입력_예외_테스트() {
        //given
        List<String> input = Arrays.asList("+", "2", "+", "-3");

        //then
        assertThrows(IllegalArgumentException.class, () -> new StringCalculator().calculator(input));
    }

    @DisplayName("입력된 문자열의 두번째가 숫자 입력 시 예외발생 테스트")
    @Test
    void 문자열_두번째_숫자_입력_예외_테스트() {
        //given
        List<String> input = Arrays.asList("2", "2", "+", "-3");

        //then
        assertThrows(IllegalArgumentException.class, () -> new StringCalculator().calculator(input));
    }
}
