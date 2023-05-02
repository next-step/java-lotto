package calculator;

import calculator.domain.Calculator;
import calculator.domain.InputConverter;
import calculator.domain.NumberGroup;
import calculator.domain.OperatorGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("수식 문자열 계산")
    public void calculateFormulaTest() {
        String testInput = " 5 - 5 + 2";

        InputConverter inputConverter = new InputConverter();
        List<String> formulaList = inputConverter.formulaToStrList(testInput);

        OperatorGroup operatorGroup = new OperatorGroup(formulaList);
        Queue<String > operatorQueue = operatorGroup.operatorQueue();

        NumberGroup numberGroup = new NumberGroup(formulaList);
        List<Double> numberList = numberGroup.numberList();

        Calculator calculator = new Calculator();

        Double result = calculator.calculateFormula(numberList, operatorQueue);

        assertThat(result).isEqualTo(2.0);
    }


}
