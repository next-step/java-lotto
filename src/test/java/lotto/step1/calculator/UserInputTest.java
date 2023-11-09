package lotto.step1.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    @ParameterizedTest
    @MethodSource("userInputStringWithSpace")
    @DisplayName("숫자와 사칙 연산 사이를 빈 공백으로 구분한 문자열이 입력되면, 해당 문자열을 숫자와 사칙 연산으로 분리한다.")
    void splitUserInputStringWithSpace(String input, String[] expectedStrings) {
        //given
        //when
        UserInput userInput = new UserInput(input);

        //then
        assertThat(userInput.split()).isEqualTo(expectedStrings);
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

    @ParameterizedTest
    @NullSource
    @DisplayName("입력 값이 null일 경우, IllegalArgumentException 예외가 발생한다.")
    void splitUserInputStringWithNull(String input) {
        //given, when, then
        assertThatThrownBy(() -> new UserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 null이 될 수 없습니다.");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("입력 값이 빈 공백 문자일 경우, IllegalArgumentException 예외가 발생한다.")
    void splitUserInputStringWithEmptyString(String input) {
        //given, when, then
        assertThatThrownBy(() -> new UserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 빈 공백이 될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ! 2", "2 @ 4", "3 # 5", "3 $ 4", "4 % 2", "5 ^ 2", "6 & 2", "7 ~ 1", "1 < 2", "1 > 2"})
    @DisplayName("입력으로 사칙연산 기호가 아닌 기호가 들어온 경우, IllegalArgumentException 예외가 발생한다.")
    void splitUserInputStringWithNotOperator(String input) {
        //given, when, then
        assertThatThrownBy(() -> new UserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자와 사칙연산 기호만 입력이 가능합니다.");
    }
}
