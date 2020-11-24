package StringAddCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringOperandTest {

    @DisplayName(value = "숫자 하나일 경우 그대로 반환")
    @Test
    void 숫자_하나() {
        // given
        String value = "1";

        // when
        List<String> tokens = StringOperand.findStringOperands(value);

        // then
        List<String> expected = Arrays.asList(value);
        Assertions.assertThat(tokens).isEqualTo(expected);
    }

    @DisplayName(value = "쉼표 구분자로 문자열을 더한다.")
    @Test
    void 쉼표_구분자() {
        // given
        String values = "1,2";

        // when
        List<String> tokens = StringOperand.findStringOperands(values);

        // then
        List<String> expected = Arrays.asList("1", "2");
        Assertions.assertThat(tokens).isEqualTo(expected);
    }

    @DisplayName(value = "쉼표, 콜론를 구분자로 문자열을 더한다.")
    @Test
    void 쉼표_또는_콜론_구분자() {
        // given
        String values = "1,2:3";

        // when
        List<String> tokens = StringOperand.findStringOperands(values);

        // then
        List<String> expected = Arrays.asList("1", "2", "3");
        Assertions.assertThat(tokens).isEqualTo(expected);
    }

    @DisplayName(value = "커스텀 구분자로 문자열을 더한다.")
    @Test
    void 커스텀_구분자() {
        // given
        String values = "//;\n1;2;3";

        // when
        List<String> tokens = StringOperand.findStringOperands(values);

        // then
        List<String> expected = Arrays.asList("1", "2", "3");
        Assertions.assertThat(tokens).isEqualTo(expected);
    }

    @DisplayName(value = "null 예외")
    @Test
    void null_예외() {
        assertThatThrownBy(() -> StringOperand.findStringOperands(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "문자열이면 예외")
    @Test
    void empty_예외() {
        assertThatThrownBy(() -> StringOperand.findStringOperands(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}