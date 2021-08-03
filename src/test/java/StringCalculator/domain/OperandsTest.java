package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import StringCalculator.exception.WrongInputException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class OperandsTest {

    @ParameterizedTest
    @MethodSource("generateDefaultDelimiterInputs")
    @DisplayName("피연산자 문자열을 디폴트구분자를 이용해 리스트로 바꿀수 있다.")
    void create_by_default_delimiter(String operandString, List<Integer> expectedList) {
        Operands operands = Operands.createByDefaultDelimiter(operandString);
        assertThat(operands.value()).isEqualTo(expectedList);
    }


    @ParameterizedTest
    @MethodSource("generateCustomDelimiterInputs")
    @DisplayName("피연산자 문자열을  커스텀구분자를 이용해 리스트로 바꿀수 있다.")
    void create_by_custom_delimiter(String operandString, String delimiter,
        List<Integer> expectedList) {
        Operands operands = Operands.createByCustomDelimiter(operandString, delimiter);
        assertThat(operands.value()).isEqualTo(expectedList);
    }


    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("피연산자 문자열이 공백이거나 null일경우에는 피연산자는 0으로 설정한다.")
    void null_or_blank_will_be_zero_operand(String operandString) {
        Operands operands = Operands.createByDefaultDelimiter(operandString);
        assertThat(operands.value()).containsOnly(0);
    }


    @ParameterizedTest
    @ValueSource(strings = {"Hello", "1,Wrong", "1,@,3"})
    @DisplayName("피연산자 문자열에 숫자가 아닌 피연산자가 입력되었을 때는 예외를 던진다.")
    void not_allow_non_number_operands(String operandString) {
        assertThatThrownBy(() -> Operands.createByDefaultDelimiter(operandString))
            .isInstanceOf(WrongInputException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0,1,-1"})
    @DisplayName("피연산자 문자열에 음수가 입력되었을 때는 예외를 던진다.")
    void not_allow_negative_number_operands(String wrongInput) {
        assertThatThrownBy(() -> new OperationInputs(wrongInput, new AddingStrategy()))
            .isInstanceOf(WrongInputException.class);
    }




    private static Stream<Arguments> generateDefaultDelimiterInputs() {

        return Stream.of(
            Arguments.of("1", Arrays.asList(1)),
            Arguments.of("1,2,3", Arrays.asList(1, 2, 3)),
            Arguments.of("1:2:3", Arrays.asList(1, 2, 3)),
            Arguments.of("1,2:3", Arrays.asList(1, 2, 3))
        );

    }


    private static Stream<Arguments> generateCustomDelimiterInputs() {

        return Stream.of(
            Arguments.of("1", ";", Arrays.asList(1)),
            Arguments.of("1;2;3", ";", Arrays.asList(1, 2, 3)),
            Arguments.of("1@2@3", "@", Arrays.asList(1, 2, 3))
        );

    }

}