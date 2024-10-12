import domain.Calculator;
import exception.WrongCalculationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    static List<String> invalidStrings() {
        String number1 = "3";
        String number2 = "2";
        String[] invalidOperators = {"!", "@", "#", "$", "%", "^", "&", "(", ")", "|"};

        return Arrays.stream(invalidOperators)
                .map(op -> number1 + " " + op + " " + number2)
                .collect(Collectors.toList());
    }
    @Test
    public void 플러스_기호가_입력되면_덧셈한다() throws WrongCalculationException {
        assertThat(calculator.calculate("3 + 2")).isEqualTo(5);
    }

    @Test
    public void 마이너스_기호가_입력되면_덧셈한다() throws WrongCalculationException {
        assertThat(calculator.calculate("3 - 2")).isEqualTo(1);
    }

    @Test
    public void 곱셈_기호가_입력되면_곱셈한다() throws WrongCalculationException {
        assertThat(calculator.calculate("3 * 2")).isEqualTo(6);
    }

    @Test
    public void 나눗셈_기호가_입력되면_나눈다() throws WrongCalculationException {
        assertThat(calculator.calculate("6 / 3")).isEqualTo(2);
    }
    @Test
    public void 영으로_나눗셈_시도_시_IllegalArgumentException_이_발생한다() {
        assertThatThrownBy(() -> calculator.calculate("6 / 0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("invalidStrings")
    public void 유효하지않은_기호_입력_시_IllegalArgumentException이_발생한다(String input){
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사칙연산 기호입니다");
    }

}
