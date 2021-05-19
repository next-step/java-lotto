package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("숫자변환 테스트")
    @Test
    void stringsToInts() {
        assertThatThrownBy(() -> StringCalculator.stringsToInts(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 이외의 값을 전달할 수 없습니다.");
        assertThatThrownBy(() -> StringCalculator.stringsToInts("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수를 전달할 수 없습니다.");

        assertThat(StringCalculator.stringsToInts("1,2")).containsExactly(1, 2);
        assertThat(StringCalculator.stringsToInts("1,2:3")).containsExactly(1, 2, 3);
        assertThat(StringCalculator.stringsToInts("//;\n1;2;3")).containsExactly(1, 2, 3);
    }

    @DisplayName("합계 테스트")
    @Test
    void sum() {
        assertThat(StringCalculator.sum("1,2")).isEqualTo(3);
        assertThat(StringCalculator.sum("1,2:3")).isEqualTo(6);
        assertThat(StringCalculator.sum("//;\n1;2;3")).isEqualTo(6);
    }
}
