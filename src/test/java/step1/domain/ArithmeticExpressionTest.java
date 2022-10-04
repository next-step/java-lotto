package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ArithmeticExpressionTest {

    @Test
    @DisplayName("사용자가 입력한 문자열 생성 테스트")
    void inputString_ctor_test() {
        assertThatNoException()
            .isThrownBy(() -> new ArithmeticExpression("1 + 1 * 5 / 2"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 값이나 공백만 입력하면 예외가 발생한다.")
    void input_null_or_blank_throw_exception_test(String input) {
        assertThatThrownBy(() -> new ArithmeticExpression(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("최소한 1개의 숫자를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1 + 5 + + 2 / 3",
        "  1 = 2 + 3",
        " 1 3 + 45"
    })
    @DisplayName("잘못된 연산식을 입력하면 예외가 발생한다.")
    void input_incorrectArithmeticExpression_throw_exception_test(String input) {
        assertThatThrownBy(() -> new ArithmeticExpression(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 연산식입니다.");
    }

    @Test
    @DisplayName("0으로 나누면 예외가 발생한다.")
    void input_zero_throw_exception_test() {
        String input = "1 + 1 / 0";

        assertThatThrownBy(() -> new ArithmeticExpression(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "  1 +   3  + 4 /    2",
        "1 + 3 * 4",
        "1 + 5 + 4"
    })
    @DisplayName("정확한 연산식을 입력하면 예외가 발생하지 않는다.")
    void input_normalArithmetic_throw_exception_test(String input) {
        assertThatNoException().isThrownBy(() -> new ArithmeticExpression(input));
    }

    @Test
    @DisplayName("숫자만 가져온다.")
    void get_only_number_test() {
        //given
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression("1 + 5   +   4   - 35");

        //when
        Numbers numbers = arithmeticExpression.numbers();

        //then
        List<Number> numberList = List.of(
            new Number(1),
            new Number(5),
            new Number(4),
            new Number(35)
        );

        assertThat(numbers).usingRecursiveComparison().isEqualTo(new Numbers(numberList));
    }

    @Test
    @DisplayName("연산자만 가져온다.")
    void get_only_operator_test() {
        //given
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression("1 + 5   +   4");

        //when
        Operators operators = arithmeticExpression.operators();

        //then
        List<Operator> operatorList = List.of(
            new Operator('+'),
            new Operator('+')
        );

        assertThat(operators).usingRecursiveComparison().isEqualTo(new Operators(operatorList));
    }
}
