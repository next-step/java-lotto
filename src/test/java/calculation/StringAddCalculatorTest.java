package calculation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringAddCalculatorTest {

    @Test
    @DisplayName("null 또는 empty 를 0으로 반환한다. (예 : '' -> 0, null -> 0)")
    public void changeTheNullAndEmptyToZero() {
        assertAll(
                () -> assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0),
                () -> assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력한 경우 숫자로 반환한다. (예 : '1')")
    public void changeStringNumberToIntegerNumber() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : '1,2')")
    public void stringArraySum() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 콤마(,) 이외에 콜론(:)을 사용할수 있다.(예 : '1,2:3' -> 6)")
    public void commaToColon() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : '//;\n1;2;3' -> 6")
    public void customDistinguish() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : '-1,2,3')")
    public void negativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringAddCalculator.splitAndSum("-1,2,3");

            fail("음수 예외가 발생해야 한다.");
        });
    }

}
