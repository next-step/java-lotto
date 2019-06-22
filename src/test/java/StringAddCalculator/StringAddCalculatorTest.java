package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringAddCalculatorTest {


    @Test
    @DisplayName("null 또는 빈 문자")
    public void nullOrEmpty() {
        assertThat(StringAddCalculator.add(null)).isEqualTo(0);
        assertThat(StringAddCalculator.add("")).isEqualTo(0);
    }

    @Test
    @DisplayName("문자 한개의 경우")
    public void sumOne() {
        assertThat(StringAddCalculator.add("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표구분자")
    public void splitCommaAndSum() {
        assertThat(StringAddCalculator.add("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자")
    public void splitCommaOrColonAndSum() {
        assertThat(StringAddCalculator.add("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자")
    public void splitCustomAndSum() {
        assertThat(StringAddCalculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 예외처리")
    public void negativeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringAddCalculator.add("-1,2,3");
        });
    }
}