package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.IllegalFormatConversionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AddCommandTest {
    @Test
    @DisplayName("빈값 or null인지 확인")
    void isEmptyTest() {
        assertThat(AddCommand.isEmpty(new AddCommand(""))).isTrue();

        assertThat(AddCommand.isEmpty(new AddCommand(null))).isTrue();

        assertThat(AddCommand.isEmpty(new AddCommand("1"))).isFalse();
    }

    @Test
    @DisplayName("숫자인 입력인지 확인")
    void isOnlyDigitTest() {
        assertThat(AddCommand.isOnlyDigit(new AddCommand("1.1"))).isFalse();

        assertThat(AddCommand.isOnlyDigit(new AddCommand("1"))).isTrue();
    }

    @Test
    @DisplayName("toInt 테스트")
    void toIntTest() {
        assertThat(new AddCommand("1").toInt()).isEqualTo(1);
    }

    @Test
    @DisplayName("toInt exception 테스트")
    void toIntExceptionTest() {
        assertThatThrownBy(() -> new AddCommand("1.1").toInt()).isInstanceOf(IllegalFormatConversionException.class);
    }

    @Test
    @DisplayName("음수를 포함하는지 확인하는 메소드 테스트")
    void containsNegativeTest() {
        assertThat(AddCommand.containsNegative(new AddCommand("-1,2,3"))).isTrue();
    }

    @Test
    @DisplayName("문자열 덧셈이 정상적으로 실행되는지 테스트")
    void executeTest() {
        AddCommand addCommand = new AddCommand("1,2:3");

        int result = addCommand.execute();
        assertThat(result).isEqualTo(6);

        AddCommand addCommand2 = new AddCommand("//;\n1;2;3");

        int result2 = addCommand2.execute();
        assertThat(result2).isEqualTo(6);
    }
}
