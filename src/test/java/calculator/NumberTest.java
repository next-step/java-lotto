package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {
    @Test
    void createNumber() {
        String input = "1";
        Number number = Number.of(input);
        assertThat(number).isNotNull();
        assertThat(number).isEqualTo(new Number(1));
    }

    @DisplayName("잘못된 입력값 일 시 에러")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a"})
    void createNonNatureNumberThenFail(String wrongInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Number.of(wrongInput))
        .withMessageMatching("잘못된 문자열 입니다.");
    }

    @DisplayName("입력 값이 음수 일 시 에러")
    @Test
    void createNoNatureNumberThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(-1))
                .withMessageMatching("숫자는 0보다 커야합니다.");
    }

    @Test
    void addNumber() {
        Number number = new Number(1);
        Number number2 = new Number(2);
        Number result = number.add(number2);
        assertThat(result).isEqualTo(new Number(3));
    }
}
