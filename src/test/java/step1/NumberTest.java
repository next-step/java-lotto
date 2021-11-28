package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    @DisplayName("생성자 테스트")
    void createFromInt() {
        assertThat(Number.createFromInt(1)).isEqualTo(Number.createFromInt(1));
        assertThat(Number.createFromInt(2)).isNotEqualTo(Number.createFromInt(1));
    }

    @Test
    @DisplayName("생성자 테스트")
    void createFromString() {
        assertThat(Number.createFromString("1")).isEqualTo(Number.createFromInt(1));
        assertThat(Number.createFromString("2")).isNotEqualTo(Number.createFromInt(1));
    }

    @Test
    @DisplayName("음수가 입력되었을 경우 유효성 체크")
    void validateNumber() {
        assertThatThrownBy(() -> Number.createFromInt(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력 숫자 오류");
    }

    @Test
    @DisplayName("숫자 사이의 구분자가 유효하지 않을 경우 유효성 체크")
    void validateNumberFromString() {
        assertThatThrownBy(() -> Number.createFromString("1$1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력 구분자 오류");
    }
}
