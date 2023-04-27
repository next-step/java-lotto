package lotto;

import lotto.domain.Calculator;
import lotto.domain.InputConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("계산")
    public void calculateTest() {
        String testInput = " 44 + 55 - 9 / 5 ";
        InputConverter inputConverter = new InputConverter();
        List<String> formulaList = inputConverter.formulaToStrList(testInput);
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
        String testInput = " 44 + 55 - 9 / 5 ";
        InputConverter inputConverter = new InputConverter();
        List<String> formulaList = inputConverter.formulaToStrList(testInput);
        Calculator calculator = new Calculator();

        calculator.calculateFormula(formulaList);

        String result = calculator.showResult();

        assertThat(result).isEqualTo("18");
    }


}
