package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Number;
import step1.domain.Numbers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    @DisplayName("생성자 테스트")
    void create() {
        assertThat(new Number(1)).isEqualTo(new Number(1));
        assertThat(new Number(2)).isNotEqualTo(new Number(1));
    }

    @Test
    @DisplayName("음수가 입력되었을 경우 유효성 체크")
    void validateNumber() {
        assertThatThrownBy(() -> new Number(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력 숫자 오류");
    }
}
