package lotto;

import lotto.domain.Calculator;
import lotto.utility.InputChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("수식 문자열에서 숫자만 List<Integer> 형태로 반환")
    public void makeNumberListTest() {
        String testInput = " 44 + 55 - 2 / 5 ";
        InputChecker inputChecker = new InputChecker();
        List<String> formulaList = inputChecker.formulaToStrList(testInput);
        Calculator calculator = new Calculator(formulaList);

        List<Integer> result = calculator.makeNumberList();

        assertThat(result.size()).isEqualTo(4);
        assertThat(result.get(0)).isEqualTo(44);
        assertThat(result.get(1)).isEqualTo(55);
        assertThat(result.get(2)).isEqualTo(2);
        assertThat(result.get(3)).isEqualTo(5);
    }

    @Test
    @DisplayName("수식 문자열에서 연산자만 List<String> 형태로 반환")
    public void makeOperatorListTest() {
        String testInput = " 44 + 55 - 2 / 5 ";
        InputChecker inputChecker = new InputChecker();
        List<String> formulaList = inputChecker.formulaToStrList(testInput);
        Calculator calculator = new Calculator(formulaList);

        List<String> result = calculator.makeOperatorList();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo("+");
        assertThat(result.get(1)).isEqualTo("-");
        assertThat(result.get(2)).isEqualTo("/");
    }

}
