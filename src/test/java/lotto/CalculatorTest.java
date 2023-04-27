package lotto;

import lotto.domain.Calculator;
import lotto.domain.InputConverter;
import lotto.domain.NumberGroup;
import lotto.domain.OperatorGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("계산")
    public void calculateTest() {
        Calculator calculator = new Calculator();

        String result = calculator.calculate("4", "5", "+");
        String result2 = calculator.calculate("4", "5", "-");
        String result3 = calculator.calculate("4", "5", "*");
        String result4 = calculator.calculate("3", "2", "/");

        assertThat(result).isEqualTo("9");
        assertThat(result2).isEqualTo("-1");
        assertThat(result3).isEqualTo("20");
        assertThat(result4).isEqualTo("1.5");
    }

    @Test
    @DisplayName("수식 문자열 계산")
    public void calculateFormulaTest() {
        String testInput = " 5 - 5 + 2";

        InputConverter inputConverter = new InputConverter();
        List<String> formulaList = inputConverter.formulaToStrList(testInput);

        OperatorGroup operatorGroup = new OperatorGroup(formulaList);
        Queue<String > operatorQueue = operatorGroup.operatorQueue();

        NumberGroup numberGroup = new NumberGroup(formulaList);
        List<String> numberList = numberGroup.numberList();

        Calculator calculator = new Calculator();

        calculator.calculateFormula(numberList, operatorQueue);
        String result = calculator.showResult();

        assertThat(result).isEqualTo("2");
    }


}
