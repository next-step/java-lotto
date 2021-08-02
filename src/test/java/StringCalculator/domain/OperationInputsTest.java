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

class OperationInputsTest {


    @ParameterizedTest
    @MethodSource("generateDefaultDelimiterInputs")
    @DisplayName("유저입력에 대해, 커스텀 구분자가 없다면 기본 구분자로 피연산자 리스트를 생성한다.")
    void split_user_inputs_by_default_delimiter(String userInput, List<Integer> expectedOperands) {
        OperationInputs inputs = new OperationInputs(userInput, new AddingStrategy());
        List<Integer> operands = inputs.getOperandsList();
        assertThat(operands).isEqualTo(expectedOperands);
    }


    @ParameterizedTest
    @MethodSource("generateCustomDelimiterInputs")
    @DisplayName("유저입력에 대해, 커스텀 구분자가 있다면 커스텀 구분자로 피연산자를 구별한다.")
    void split_user_inputs_by_custom_delimiter(String userInput, List<Integer> expectedOperands) {
        OperationInputs inputs = new OperationInputs(userInput, new AddingStrategy());
        List<Integer> operands = inputs.getOperandsList();
        assertThat(operands).isEqualTo(expectedOperands);
    }


    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2,3", "//;\n1:2;3"})
    @DisplayName("유저입력에 대해, 커스텀 구분자가 있다면 디폴트 구분자는 기능하지 못한다.")
    void custom_delimiter_does_not_work_with_default_delimiter(String userInput) {
        assertThatThrownBy(() -> new OperationInputs(userInput, new AddingStrategy()))
            .isInstanceOf(WrongInputException.class);


    }


    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("유저 입력이 공백이거나 null일경우에는 피연산자는 0으로 설정한다.")
    void null_or_blank_will_be_zero_operand(String userInput) {
        OperationInputs inputs = new OperationInputs(userInput, new AddingStrategy());
        List<Integer> operands = inputs.getOperandsList();
        assertThat(operands).containsOnly(0);
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
            Arguments.of("//;\n1", Arrays.asList(1)),
            Arguments.of("//;\n1;2;3", Arrays.asList(1, 2, 3)),
            Arguments.of("//@\n1@2@3", Arrays.asList(1, 2, 3))
        );

    }


}