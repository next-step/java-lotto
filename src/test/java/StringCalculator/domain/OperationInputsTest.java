package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperationInputsTest {


    @ParameterizedTest
    @MethodSource("generateDefaultDemititerInputs")
    @DisplayName("유저입력에 대해, 커스텀 구분자가 없다면 기본 구분자로 피연산자 리스트를 생성한다.")
    void split_user_inputs_by_default_delimiter(String userInput, List<Integer> expectedOperands) {
        OperationInputs inputs = new OperationInputs(userInput, new AddingStrategy());
        List<Integer> operands = inputs.getOperands();
        assertThat(operands).isEqualTo(expectedOperands);
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