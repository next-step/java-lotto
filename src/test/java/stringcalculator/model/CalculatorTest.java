package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static stringcalculator.model.Operator.convertToOperator;

public class CalculatorTest {

    @Test
    void 문자열을_피연산자와_연산자_목록으로_계산기에_저장한다() {
        List<Operand> operands = Arrays.asList(
                Operand.of("2"),
                Operand.of("3"),
                Operand.of("4"),
                Operand.of("2")
                );
        List<Operator> operators = Arrays.asList(
                convertToOperator("+"),
                convertToOperator("*"),
                convertToOperator("/")
        );
        new Calculator(operands, operators);
    }

    @ParameterizedTest(name = "사칙연산들을_계산한다({0} {1} {2} {3} {4} {5} {6} = {7})")
    @CsvSource(value = {
            "2,+,3,*,4,/,2,10",
            "8,+,9,*,9,/,36,4",
    })
    void 사칙연산들을_계산한다(String operand,
                             String operator1, String operand1,
                             String operator2, String operand2,
                             String operator3, String operand3,
                             int result) {
        List<Operand> operands = Arrays.asList(
                Operand.of(operand),
                Operand.of(operand1),
                Operand.of(operand2),
                Operand.of(operand3)
        );
        List<Operator> operators = Arrays.asList(
                convertToOperator(operator1),
                convertToOperator(operator2),
                convertToOperator(operator3)
        );
        Calculator calculator = new Calculator(operands, operators);
        Result actual = calculator.calculate();
        Result expected = new Result(result);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
