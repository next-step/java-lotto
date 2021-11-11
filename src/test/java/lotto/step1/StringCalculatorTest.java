package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 값이 빈문자열 or null -> 0 반환")
    void nullOrEmpty() {
        assertThat(StringCalculator.addString(null)).isEqualTo(0);
        assertThat(StringCalculator.addString("")).isEqualTo(0);
    }

    // private 선언
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

    @Test
    @DisplayName("분리된 숫자 합 계산 private 선언후 sum() -> addString() 변경")
    void sum() {
        assertThat(StringCalculator.addString("3,4:5")).isEqualTo(12);
        assertThat(StringCalculator.addString("//;\n3;4;5")).isEqualTo(12);
    }

    @ParameterizedTest
    @ValueSource(strings =
            {"3,4:ee", "l,l:ll",
            "-1,-2:3", "3,4:-1",
            "1,2&3"})
    @DisplayName("마이너스 값 or 숫자가 아닌 값 에러 or 구분자 잘못 입력")
    void checkMinusOrNotNumber(String value) {
        assertThatThrownBy(() -> StringCalculator.addString(value))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings =
            {"3,4:5", "3:4,5", "3,4,5", "3:4:5",
            "//;\n3;4;5", "//&\n3&4&5", "//@\n3@4@5"})
    @DisplayName("입력값 받아서 최종 합산 값")
    void addString(String value) {
        assertThat(StringCalculator.addString(value)).isEqualTo(12);
        assertThat(StringCalculator.addString("")).isEqualTo(0);
        assertThat(StringCalculator.addString(null)).isEqualTo(0);
    }

}
