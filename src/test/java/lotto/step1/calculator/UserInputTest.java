package lotto.step1.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {
    @ParameterizedTest
    @MethodSource("userInputStringWithSpace")
    @DisplayName("숫자와 사칙 연산 사이를 빈 공백으로 구분한 문자열이 입력되면, 해당 문자열을 숫자와 사칙 연산으로 분리한다.")
    void splitUserInputStringWithSpace(String input, String[] expectedStrings) {
        //given
        //when
        UserInput userInput = new UserInput(input);

        //then
        assertThat(userInput.getInputs()).isEqualTo(expectedStrings);
    }

    public static Stream<Arguments> userInputStringWithSpace() {
        return Stream.of(
                Arguments.of("1 + 2", new String[]{"1", "+", "2"}),
                Arguments.of("2 - 4", new String[]{"2", "-", "4"}),
                Arguments.of("3 * 5", new String[]{"3", "*", "5"}),
                Arguments.of("4 / 2", new String[]{"4", "/", "2"}),
                Arguments.of("5 + 2 * 2 - 3 / 4", new String[]{"5", "+", "2", "*", "2", "-", "3", "/", "4"})
        );
    }
}
