package calculator.domain.expression;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("피연산자 테스트")
class OperandTest {

    @ParameterizedTest(name = "피연산자 객체는 숫자가 아닌 문자열로 생성하면 예외가 발생한다")
    @ValueSource(strings = {"A", "Z", "@", "]"})
    void 피연산자_객체는_숫자문자열만_생성할수있다(String operand) {
        Assertions.assertThatThrownBy(() -> new Operand(operand))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "피연산자 객체에서 숫자를 꺼낼수있다")
    @ValueSource(strings = {"1", "909", "1004", "10009"})
    void 문자열로_생성한_피연산자_객체에서_숫자를_꺼낼수_있다(String input) {
        Operand operand = new Operand(input);
        int number = operand.toInt();
        Assertions.assertThat(number).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest(name = "피연산자 객체는 음수형태의 문자열로 생성할수없다")
    @ValueSource(strings = {"-1", "-9", "-1004"})
    void 피연산자_객체_생성시_음수문자열을_전달하면_예외가_발생한다(String operand) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Operand(operand))
                .withMessage("Negative numbers are not allowed");
    }

    @ParameterizedTest(name = "피연산자 객체는 음수로는 생성할 수 없다")
    @ValueSource(ints = {-1, -9, -1004})
    void 피연산자_객체_생성시_음수를_전달하면_예외가_발생한다(int operand) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Operand(operand))
                .withMessage("Negative numbers are not allowed");
    }


}