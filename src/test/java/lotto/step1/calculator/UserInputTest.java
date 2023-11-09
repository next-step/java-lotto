package lotto.step1.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    @ParameterizedTest
    @MethodSource("userInputStringWithSpace")
    @DisplayName("숫자와 사칙 연산 사이를 빈 공백으로 구분한 문자열이 입력되면, 해당 문자열을 숫자와 사칙 연산으로 분리한다.")
    void splitUserInputStringWithSpace(String userInputString, String[] expectedStrings) {
        //given
        //when
        UserInput userInput = new UserInput(userInputString);

        //then
        assertThat(userInput.split()).isEqualTo(expectedStrings);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우, IllegalArgumentException 예외가 발생한다.")
    void splitUserInputStringWithNullAndEmptyString(String userInputString) {
        //given, when, then
        assertThatThrownBy(() -> new UserInput(userInputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 null 혹은 빈 공백일 수 없습니다.");
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
