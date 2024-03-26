package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.operator.Operator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


public class CalculatorTest {


    @ParameterizedTest
    @NullAndEmptySource
    public void 입력값_null_또는_공백인_경우_예외_발생(String input) {
        assertThatThrownBy(() -> {
            Validator.validateInputNullOrEmpty(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 또는 빈 문자열은 입력할 수 없습니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {"%", "***"})
    public void 사칙연산_기호가_아닌_경우_예외_발생(String operator) {
        assertThatThrownBy(() -> {
            OperationFactory.getOperator(operator);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 기호입니다.");
    }

    @Test
    public void 사칙연산_우선순위_고려하지_않고_순서대로_실행() {
        CalculatorService calculatorService = new CalculatorService();
        List<String> inputs = Stream.of("2", "+", "3", "*", "4", "/", "2")
                .collect(Collectors.toList());
        assertThat(calculatorService.start(inputs)).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource({"1,16,17", "4,8,12"})
    public void 덧셈(int number1, int number2, int expectResult) {
        Operator operator = OperationFactory.getOperator("+");
        assertThat(operator.calculate(number1, number2)).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource({"4,5,-1", "22,8,14"})
    public void 뺄셈(int number1, int number2, int expectResult) {
        Operator operator = OperationFactory.getOperator("-");
        assertThat(operator.calculate(number1, number2)).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource({"15,5,3", "100,1,100"})
    public void 나눗셈(int number1, int number2, int expectResult) {
        Operator operator = OperationFactory.getOperator("/");
        assertThat(operator.calculate(number1, number2)).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource({"3,4,12", "1,1,1"})
    public void 곱셈(int number1, int number2, int expectResult) {
        Operator operator = OperationFactory.getOperator("*");
        assertThat(operator.calculate(number1, number2)).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource({"1,0"})
    public void 분모에_0입력시_나눗셈_불가능(int number1, int number2) {
        Operator operator = OperationFactory.getOperator("/");

        assertThatThrownBy(() -> {
            operator.calculate(number1, number2);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("0으로는 나눌 수 없습니다");
    }


}
