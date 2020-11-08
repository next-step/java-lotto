package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitStringTest {

    @DisplayName("null과 공백문자 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("하나의 숫자 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "5", "6"})
    public void splitAndSum_숫자하나(String input) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("쉼표구분자 테스트")
    @ParameterizedTest
    @MethodSource("provideCommaAndResult")
    public void splitAndSum_쉼표구분자(String input, int resultValue) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(resultValue);
    }

    private static Stream<Arguments> provideCommaAndResult() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2",3)
        );
    }

    @DisplayName("쉼표및 콜론 구분자 테스트")
    @ParameterizedTest
    @MethodSource("provideCommaWithColonAndResult")
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int resultValue) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(resultValue);
    }

    private static Stream<Arguments> provideCommaWithColonAndResult() {
        return Stream.of(
                Arguments.of("1,2:3", 6),
                Arguments.of("1:2,4",7)
        );
    }
    @DisplayName("사용자 정의 구분자 테스트")
    @ParameterizedTest
    @MethodSource("provideCustomSeparatorAndResult")
    public void splitAndSum_custom_구분자(String input, int resultValue) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(resultValue);
    }

    private static Stream<Arguments> provideCustomSeparatorAndResult() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//~\n1~2~3", 6)
        );
    }

    @DisplayName("음수 예외 테스트")
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
