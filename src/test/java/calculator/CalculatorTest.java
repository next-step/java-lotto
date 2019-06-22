package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-20
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void add_공백_또는_null_입력시_0반환(String input) {
        Calculator calculator = new Calculator();

        assertThat(calculator.add(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "10", "100", "0"})
    void add_숫자_하나를_문자열로_입력할경우_해당숫자를_반환(String input) {
        Calculator calculator = new Calculator();
        int expected = Integer.valueOf(input);

        assertThat(calculator.add(input)).isEqualTo(expected);
    }


    // TODO 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.

    // TODO 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.

    // TODO “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.

    // TODO 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.
}
