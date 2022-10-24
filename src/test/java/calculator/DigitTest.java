package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitTest {

    @Test
    @DisplayName("입력 문자열이 숫자가 맞으면 true를 반환한다.")
    public void isDigit() {
        boolean actual = Digit.isDigit("3");

        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자를 파싱해 반환한다.")
    public void isDigit() {
        List<Integer> actual = Digit.parseDigits(List.of("3", "+", "5"));

        assertThat(actual).isEqualTo(List.of(3, 5));
    }
}
