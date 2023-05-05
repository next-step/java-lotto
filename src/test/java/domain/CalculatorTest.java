package domain;

import static domain.formula.Numbers.getNumbersByFormula;
import static domain.formula.Operators.getOperatorsByFormula;

import domain.formula.Formula;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("문자열 계산기 전체 기능 테스트")
    public void CalculatorTest() {

        List<String> plainFormula = List.of(new String[]{"2", "+", "3", "*", "4", "/", "2"});
        Formula formula = new Formula(getNumbersByFormula(plainFormula),
                getOperatorsByFormula(plainFormula));

        Calculator calculate = Calculator.calculate(formula);

        Assertions.assertThat(calculate.getResult()).isEqualTo(new CalculationResult(10));
    }
}
