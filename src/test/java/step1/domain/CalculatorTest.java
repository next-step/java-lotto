package step1.domain;

import step1.exception.WrongCalculationException;
import step1.model.Operands;
import step1.model.Operators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    Calculator calculator;
    Operands operands;
    Operators operators;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
        operands = Operands.getInstance();
        operators = Operators.getInstance();

        operands.clear();
        operators.clear();
    }

    static List<String> invalidStrings() {
        String number1 = "3";
        String number2 = "2";
        String[] invalidOperators = {"!", "@", "#", "$", "%", "^", "&", "(", ")", "|"};

        return Arrays.stream(invalidOperators)
                .map(op -> number1 + " " + op + " " + number2)
                .collect(Collectors.toList());
    }

    @Test
    public void 플러스_기호가_입력되면_덧셈한다() throws WrongCalculationException {
        operands.addOperand(new Operand(3));  // Operand 객체 추가
        operands.addOperand(new Operand(2));  // Operand 객체 추가
        operators.addOperator(Operator.PLUS); // Operator 추가

        assertThat(calculator.calculate()).isEqualTo(5);
    }

    @Test
    public void 마이너스_기호가_입력되면_뺄셈한다() throws WrongCalculationException {
        operands.addOperand(Operand.of(3));
        operands.addOperand(Operand.of(2));
        operators.addOperator(Operator.MINUS);

        assertThat(calculator.calculate()).isEqualTo(1);
    }

    @Test
    public void 곱셈_기호가_입력되면_곱셈한다() throws WrongCalculationException {
        operands.addOperand(new Operand(3));
        operands.addOperand(new Operand(2));
        operators.addOperator(Operator.MULTIPLY);

        assertThat(calculator.calculate()).isEqualTo(6);
    }

    @Test
    public void 나눗셈_기호가_입력되면_나눈다() throws WrongCalculationException {
        operands.addOperand(new Operand(6));
        operands.addOperand(new Operand(3));
        operators.addOperator(Operator.DIVIDE);

        assertThat(calculator.calculate()).isEqualTo(2);
    }

    @Test
    public void 영으로_나눗셈_시도_시_IllegalArgumentException_이_발생한다() {
        operands.addOperand(new Operand(6));
        operands.addOperand(new Operand(0));
        operators.addOperator(Operator.DIVIDE);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("invalidStrings")
    public void 유효하지않은_기호_입력_시_IllegalArgumentException이_발생한다(String input) {
        operands.addOperand(new Operand(3));
        operands.addOperand(new Operand(2));

        assertThatThrownBy(() -> {
            operators.addOperator(Operator.getInstance(input)); // 잘못된 연산 기호를 추가
            calculator.calculate();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사칙연산 기호입니다");
    }
}
