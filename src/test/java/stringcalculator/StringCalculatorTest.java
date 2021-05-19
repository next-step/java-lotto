package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("쉼표 또는 콜론 구분자 테스트")
    @Test
    void split_쉼표또는콜론구분자() {
        assertThat(StringCalculator.split("")).containsExactly("");
        assertThat(StringCalculator.split("1,2")).containsExactly("1", "2");
        assertThat(StringCalculator.split("1,2,3")).containsExactly("1", "2", "3");
        assertThat(StringCalculator.split("1,2:3")).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자 테스트")
    @Test
    void split_커스텀구분자() {
        assertThat(StringCalculator.split("//;\n1;2;3")).containsExactly("1", "2", "3");
        assertThat(StringCalculator.split("//#\n1#2;3")).containsExactly("1", "2;3");
    }
}
