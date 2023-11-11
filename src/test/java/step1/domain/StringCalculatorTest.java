package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domain.operator.*;
import step1.domain.operator.impl.Add;
import step1.domain.operator.impl.Divide;
import step1.domain.operator.impl.Multiply;
import step1.domain.operator.impl.Subtract;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private final String COMMON_INPUT = "2 + 3 * 4 / 2";
    private List<Operator> operatorList = Arrays.asList(new Add(), new Subtract(), new Multiply(), new Divide());
    @Test
    @DisplayName("문자열 계산기 생성")
    void create() {
        StringCalculator stringCalculator = new StringCalculator(operatorList);
        assertThat(stringCalculator).isInstanceOf(StringCalculator.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 IllegalException 예외 발생")
    void add(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(operatorList).calculate(input));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(operatorList).calculate(null));
    }

    @Test
    @DisplayName("숫자와 사칙연산 기호 이외의 문자가 포함된 경우 IllegalException 예외 발생")
    void inputCheck() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(operatorList).calculate("1,2,3"));
    }

    @Test
    @DisplayName("문자열 계산기 결과 출력")
    void result() {
        StringCalculator stringCalculator = new StringCalculator(operatorList);
        assertThat(stringCalculator.calculate(COMMON_INPUT)).isEqualTo(10);
    }
}
