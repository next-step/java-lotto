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
    void 사칙연산자로_enum_조회(String operator, OperatorGroup operatorGroup) {
        assertThat(OperatorGroup.findByOperator(operator)).isEqualTo(operatorGroup);
    }

    @ParameterizedTest
    @CsvSource({
            "+,2,3,5",
            "-,3,2,1",
            "*,3,2,6",
            "/,6,2,3"
    })
    void 사칙연산_계산(String operator, double ond1, double ond2, double expected) {
        assertThat(OperatorGroup.findByOperator(operator).calculate(ond1, ond2)).isEqualTo(expected);
    }

    @Test
    void 사칙연산자_잘못된_기호_예외() {
        assertThatThrownBy(() -> OperatorGroup.findByOperator("?"))
                .isInstanceOf(WrongOperatorException.class);
    }
}
