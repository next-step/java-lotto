package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringSequenceCalculatorTest {

    @ParameterizedTest(name = "입력받은 문자열을 앞에서부터 차례대로 계산할 수 있다. {0}")
    @ValueSource(strings = {"1+2=3", "1+2+3=6", "1+2+3-4=2", "1+2*2/2-1=2"})
    void calculateTest(String token) {
        final String input = token.split("=")[0];
        final Integer expected = Integer.parseInt(token.split("=")[1]);

        final int calculate = new StringSequenceCalculator().calculate(new Expression(input));

        assertThat(calculate).isEqualTo(expected);
    }

    @ParameterizedTest(name = "숫자와 연산자가 존재해지 않으면 예외가 발생한다. {0}")
    @ValueSource(strings = {"12", "+-/", "", " "})
    void numbersIsNotEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new StringSequenceCalculator().calculate(new Expression(input)));
    }

}
