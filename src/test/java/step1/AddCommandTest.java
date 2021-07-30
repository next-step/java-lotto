package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("커스텀 구분자가 있는지 확인")
    void hasCustomDelimiterTest() {
        assertThat(AddCommand.hasCustomDelimiter(new AddCommand("1.1"))).isFalse();

        assertThat(AddCommand.hasCustomDelimiter(new AddCommand("//;\\n1;2;3"))).isTrue();
    }
}
