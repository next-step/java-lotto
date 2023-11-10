package lotto.step1.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {
    @ParameterizedTest
    @MethodSource("userInputWithWhiteSpace")
    @DisplayName("숫자와 사칙 연산 사이를 빈 공백으로 구분한 문자열이 입력되면, 해당 문자열을 숫자와 사칙 연산으로 분리한다.")
    void splitUserInputWithWhiteSpace(String input, List<String> expectedNums, List<String> expectedOperators) {
        //given
        //when
        UserInput userInput = new UserInput(input);

        //then
        assertThat(userInput.getNums()).containsExactlyElementsOf(expectedNums);
        assertThat(userInput.getOperators()).containsExactlyElementsOf(expectedOperators);
    }

    public static Stream<Arguments> userInputWithWhiteSpace() {
        return Stream.of(
                Arguments.of("1 + 2",
                        List.of("1", "2"),
                        List.of("+")),
                Arguments.of("2 - 4",
                        List.of("2", "4"),
                        List.of("-")),
                Arguments.of("3 * 5",
                        List.of("3", "5"),
                        List.of("*")),
                Arguments.of("4 / 2",
                        List.of("4", "2"),
                        List.of("/")),
                Arguments.of("5 + 2 * 2 - 3 / 4",
                        List.of("5", "2", "2", "3", "4"),
                        List.of("+", "*", "-", "/")),
                Arguments.of("5 - 2 / 2 * 3 + 4 - 3 + 2",
                        List.of("5", "2", "2", "3", "4", "3", "2"),
                        List.of("-", "/", "*", "+", "-", "+"))
        );
    }
}
