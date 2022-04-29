package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "연산자 테스트")
class OperatorTest {

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} => {1}")
    @CsvSource(value = {"+:ADD", "-:SUBTRACT", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void 연산자_문자열_을_Enum_타입으로_변환(String input, Operator operator) {
        assertThat(Operator.toEnum(input)).isEqualTo(operator);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0}")
    @ValueSource(strings = {"가", "t"})
    @NullAndEmptySource
    void 연산자_문자열이_아닌_문자를_Enum_타입으로_변환하면_예외(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Operator.toEnum(input)
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {1} {0} {2} = {3}")
    @CsvSource(value = {"ADD-1-1-2", "SUBTRACT-1-1-0", "MULTIPLY-2-2-4", "DIVIDE-4-2-2"}, delimiter = '-')
    void 연산자에_해당하는_연산을_수행(Operator operator, int operandLeft, int operandRight, int result) {
        assertThat(operator.operate(operandLeft, operandRight)).isEqualTo(result);
    }

    @Test
    void _0으로_나누는_경우_예외() {
        assertThatThrownBy(() -> Operator.DIVIDE.operate(10, 0))
                .isExactlyInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} / {1}")
    @CsvSource(value = {"1-2", "5-3", "7-3"}, delimiter = '-')
    void 나누어_떨어지지_않는_나누기_연산하는_경우_예외(int operandLeft, int operandRight) {

        assertThatIllegalArgumentException().isThrownBy(
                () -> Operator.DIVIDE.operate(operandLeft, operandRight)
        );

    }
}