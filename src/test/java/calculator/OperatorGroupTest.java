package calculator;

import calculator.exception.WrongOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorGroupTest {
    @ParameterizedTest
    @CsvSource({
            "+,PLUS",
            "-,MINUS",
            "*,MULTI",
            "/,DIVIDE"
    })
    @DisplayName("사칙연산자 문자열로 enum을 조회한다")
    void findEnumByOperatorString(String operator, OperatorGroup operatorGroup) {
        assertThat(OperatorGroup.findByOperator(operator)).isEqualTo(operatorGroup);
    }

    @ParameterizedTest
    @CsvSource({
            "+,2,3,5",
            "-,3,2,1",
            "*,3,2,6",
            "/,6,2,3"
    })
    @DisplayName("사칙연산자를 계산한다")
    void calculate(String operator, double ond1, double ond2, double expected) {
        assertThat(OperatorGroup.findByOperator(operator).calculate(ond1, ond2)).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙연산자 외의 문자가 사용되면 예외가 발생한다")
    void wrongOperator() {
        assertThatThrownBy(() -> OperatorGroup.findByOperator("?"))
                .isInstanceOf(WrongOperatorException.class);
    }
}
