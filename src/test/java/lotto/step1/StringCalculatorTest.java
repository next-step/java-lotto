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
        assertThat(StringCalculator.addString(input)).isEqualTo(0);
        assertThat(StringCalculator.addString(input)).isEqualTo(0);
    }

//    @Test
//    @DisplayName("기본 구분자로 문자열 쪼개기")
//    void splitBasic() {
//        String[] array = StringCalculator.splitValue("3,4:5");
//        assertThat(array).containsExactly("3", "4", "5");
//    }
//
//    @Test
//    @DisplayName("커스텀 구분자로 문자열 쪼개기")
//    void splitCustom() {
//        String[] array = StringCalculator.splitValue("//;\n3;4;5");
//        assertThat(array).containsExactly("3", "4", "5");
//    }

    @ParameterizedTest
    @MethodSource("provideErrorValue")
    @DisplayName("마이너스 값 or 숫자가 아닌 값 or 구분자 잘못 입력 -> RuntimeException 발생")
    void sum(String input) {
        assertThatThrownBy(() -> StringCalculator.addString(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideErrorValue() {
        return Stream.of(
                Arguments.of("3,-1:5", null),
                Arguments.of("3:e,5", null),
                Arguments.of("1,2&3", null),
                Arguments.of("l,l:ll", null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCorrectValue")
    @DisplayName("입력값 받아서 최종 합산 값")
    void addString(String value, int expected) {
        assertThat(StringCalculator.addString(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCorrectValue() {
        return Stream.of(
                Arguments.of("3,4:5", 12),
                Arguments.of("3:4,5", 12),
                Arguments.of("3:4:5", 12),
                Arguments.of("//;\n3;4;5", 12),
                Arguments.of("//&\n3&4&5", 12),
                Arguments.of("//@\n3@4@5", 12)
        );
    }


}
