package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열 값이 빈문자열 or null -> 0 반환")
    void nullOrEmpty(String input) {
        assertThat(StringCalculator.checkNullOrEmpty(input)).isTrue();
        assertThat(StringCalculator.checkNullOrEmpty(input)).isTrue();
        assertThat(StringCalculator.addString(input)).isEqualTo(0);
        assertThat(StringCalculator.addString(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("기본 구분자로 문자열 쪼개기")
    void splitBasic() {
        String[] array = StringCalculator.splitValue("3,4:5");
        assertThat(array).containsExactly("3", "4", "5");
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열 쪼개기")
    void splitCustom() {
        String[] array = StringCalculator.splitValue("//;\n3;4;5");
        assertThat(array).containsExactly("3", "4", "5");
    }

    @ParameterizedTest
    @MethodSource("provideStringArray")
    @DisplayName("분리된 숫자 합 계산")
    void sum(String[] input) {
        assertThat(StringCalculator.sum(new String[]{"3", "1", "5"})).isEqualTo(9);
        assertThatThrownBy(() -> StringCalculator.sum(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideStringArray() {
        return Stream.of(
                Arguments.of(new String[]{"3", "-1", "5"}, null),
                Arguments.of(new String[]{"3", "e", "5"}, null)
        );
    }

    @ParameterizedTest
    @ValueSource(strings =
            {"3,4:ee", "l,l:ll",
            "-1,-2:3", "3,4:-1",
            "1,2&3"})
    @DisplayName("마이너스 값 or 숫자가 아닌 값 에러 or 구분자 잘못 입력")
    void checkMinusOrNotNumber(String value) {
        assertThatThrownBy(() -> StringCalculator.checkMinusOrNotNumber(value))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings =
            {"3,4:5", "3:4,5", "3,4,5", "3:4:5",
            "//;\n3;4;5", "//&\n3&4&5", "//@\n3@4@5"})
    @DisplayName("입력값 받아서 최종 합산 값")
    void addString(String value) {
        assertThat(StringCalculator.addString(value)).isEqualTo(12);
    }

}
