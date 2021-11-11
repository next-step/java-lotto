package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 값이 빈문자열 or null -> 0 반환")
    void nullOrEmpty1() {
        assertThat(StringCalculator.checkNullOrEmpty(null)).isTrue();
        assertThat(StringCalculator.checkNullOrEmpty("")).isTrue();
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

    @Test
    @DisplayName("분리된 숫자 합")
    void addTest() {
        assertThat(StringCalculator.sum(StringCalculator.splitValue("3,4:5"))).isEqualTo(12);
        assertThat(StringCalculator.sum(StringCalculator.splitValue("//;\n3;4;5"))).isEqualTo(12);
    }

    @Test
    @DisplayName("마이너스 값 or 숫자가 아닌 값 에러")
    void checkMinusOrNotNumber() {
        assertThatThrownBy(() -> StringCalculator.checkMinusOrNotNumber("3,4:ee"))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> StringCalculator.checkMinusOrNotNumber("3,4:-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("통합")
    void test() {
        assertThat(StringCalculator.addString("3,4:5")).isEqualTo(12);
        assertThat(StringCalculator.addString("//;\n3;4;5")).isEqualTo(12);
        assertThat(StringCalculator.addString("")).isEqualTo(0);
        assertThat(StringCalculator.addString(null)).isEqualTo(0);

    }

}
