package lotto.step1.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {
    @ParameterizedTest
    @MethodSource("operatorInputs")
    @DisplayName("findBySymbol에 적절한 사칙연산 기호를 입력하면, 해당하는 사칙연산 기호에 맞게 계산을 하는 Operator를 반환한다.")
    void returnMatchingOperatorWhenSymbolIsMatched(final String operatorSymbol, final List<String> nums, final String expectedResult) {
        //given
        Operator operator = Operator.findBySymbol(operatorSymbol);

        //when
        String result = operator.calculate(nums.get(0), nums.get(1));

        //then
        assertThat(operator).isNotNull();
        assertThat(result).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> operatorInputs() {
        return Stream.of(
                Arguments.of("+",
                        List.of("1", "2"),
                        "3"),
                Arguments.of("-",
                        List.of("2", "4"),
                        "-2"),
                Arguments.of("*",
                        List.of("3", "5"),
                        "15"),
                Arguments.of("/",
                        List.of("4", "2"),
                        "2")
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "#", "$", "%", "^", "&", "~", "<", ">"})
    @DisplayName("findBySymbol에 존재하지 않는 사칙연산 기호를 입력하면, IllegalArgumentException 예외가 발생한다.")
    void throwIllegalArgumentExceptionWhenSymbolIsNotFound(final String operatorSymbol) {
        //given, when, then
        assertThatThrownBy(() -> Operator.findBySymbol(operatorSymbol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(operatorSymbol + " is not supported");
    }
}
