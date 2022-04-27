package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "Number 테스트")
class NumberTest {

    @Test
    void 정수_입력_값을_Wrapping_하는_객체를_생성() {
        int input = 1;

        Number number1 = new Number(input);
        Number number2 = new Number(input);

        assertThat(number1).isEqualTo(number2);
    }

    @Test
    void 문자열_입력_값을_Wrapping_하는_객체를_생성() {
        String text = "1";

        Number number1 = new Number(text);
        Number number2 = new Number(text);

        assertThat(number1).isEqualTo(number2);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @NullAndEmptySource
    void 문자열_입력_값이_널이거나_빈_문자열이면_예외(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(text));
    }

    @Test
    void 더하기_테스트() {
        Number first = new Number(1);
        Number second = new Number(2);
        OperationStrategy operationStrategy = Operator.ADD.getOperationStrategy();

        Number result = first.operate(operationStrategy, second);

        assertThat(result).isEqualTo(new Number(3));
    }

    @Test
    void 빼기_테스트() {
        Number first = new Number(1);
        Number second = new Number(2);
        OperationStrategy operationStrategy = Operator.SUBTRACT.getOperationStrategy();

        Number result = first.operate(operationStrategy, second);

        assertThat(result).isEqualTo(new Number(-1));
    }

    @Test
    void 곱하기_테스트() {
        Number first = new Number(3);
        Number second = new Number(2);
        OperationStrategy operationStrategy = Operator.MULTIPLY.getOperationStrategy();

        Number result = first.operate(operationStrategy, second);

        assertThat(result).isEqualTo(new Number(6));
    }

    @Test
    void 나누기_테스트() {
        Number first = new Number(6);
        Number second = new Number(2);
        OperationStrategy operationStrategy = Operator.DIVIDE.getOperationStrategy();

        Number result = first.operate(operationStrategy, second);

        assertThat(result).isEqualTo(new Number(3));
    }

    @Test
    void _0으로_나누면_예외() {
        Number first = new Number(1);
        Number second = new Number(0);
        OperationStrategy operationStrategy = Operator.DIVIDE.getOperationStrategy();

        assertThatIllegalArgumentException().isThrownBy(
                () -> first.operate(operationStrategy, second)
        );
    }
}