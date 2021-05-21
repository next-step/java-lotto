package study2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study2.domain.PositiveNumber;

public class PositiveNumberTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        // given & when & then
        assertThat(PositiveNumber.of("0")).isEqualTo(PositiveNumber.of(0));
    }

    @Test
    @DisplayName("음수 예외 테스트")
    void negative() {
        // given & when & then
        assertThatThrownBy(() -> PositiveNumber.of("-1"))
            .isInstanceOf(RuntimeException.class);
    }
}
