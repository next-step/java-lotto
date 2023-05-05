package domain.formula;

import static domain.Operator.IS_NOT_SYMBOL_ERROR_MESSAGE;
import static domain.formula.Operators.getOperatorsByFormula;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorsTest {


    @Test
    @DisplayName("연산부호가 아닌 값을 입력했을 경우 오류가 발생한다.")
    void parseIntErrorTest() {
        List<String> formula = List.of(new String[]{"x", "4", "!"});
        assertThatThrownBy(() -> new Operators(formula))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_SYMBOL_ERROR_MESSAGE);
    }


    @Test
    @DisplayName("정확한 값이 입력되면 Operators 객체가 생성된다.")
    void makeNumbers() {
        List<String> formula = List.of(new String[]{"1", "+", "2", "+", "3"});
        Operators operatorsByFormula = getOperatorsByFormula(formula);

        List<String> stringList = Arrays.asList("+", "+");
        Operators expected = new Operators(stringList);

        assertThat(operatorsByFormula).isEqualTo(expected);
    }
}
