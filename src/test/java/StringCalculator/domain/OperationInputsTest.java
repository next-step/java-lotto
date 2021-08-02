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
    @MethodSource("generateDefaultDemititerInputs")
    @DisplayName("유저입력에 대해, 커스텀 구분자가 없다면 기본 구분자로 피연산자 리스트를 생성한다.")
    void split_user_inputs_by_default_delimiter(String userInput, List<Integer> expectedOperands) {
        OperationInputs inputs = new OperationInputs(userInput, new AddingStrategy());
        List<Integer> operands = inputs.getOperands();
        assertThat(operands).isEqualTo(expectedOperands);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("유저 입력이 공백이거나 null일경우에는 피연산자는 0으로 설정한다.")
    void null_or_blank_will_be_zero_operand(String userInput) {
        OperationInputs inputs = new OperationInputs(userInput, new AddingStrategy());
        List<Integer> operands = inputs.getOperands();
        assertThat(operands).containsOnly(0);
    }


    @ParameterizedTest
    @ValueSource(strings = {"Hello", "1,Wrong", "1,@,3"})
    @DisplayName("숫자가 아닌 피연산자가 입력되었을 때는 예외를 던진다.")
    void not_allow_non_number_operands(String wrongInput) {
        assertThatThrownBy(() -> new OperationInputs(wrongInput, new AddingStrategy()))
            .isInstanceOf(WrongInputException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0,1,-1"})
    @DisplayName("음수인 피연산자가 입력되었을 때는 예외를 던진다.")
    void not_allow_negative_number_operands(String wrongInput) {
        assertThatThrownBy(() -> new OperationInputs(wrongInput, new AddingStrategy()))
            .isInstanceOf(WrongInputException.class);
    }


    private static Stream<Arguments> generateDefaultDemititerInputs() {

        return Stream.of(
            Arguments.of("1", Arrays.asList(1)),
            Arguments.of("1,2,3", Arrays.asList(1, 2, 3)),
            Arguments.of("1:2:3", Arrays.asList(1, 2, 3)),
            Arguments.of("1,2:3", Arrays.asList(1, 2, 3))
        );

    }


}