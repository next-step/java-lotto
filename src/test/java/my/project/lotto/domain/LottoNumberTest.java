package my.project.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-11-27 오후 2:38
 * Developer : Seo
 */
class LottoNumberTest {
    @DisplayName("번호는 0보다 크고")
    @Test
    void shouldBeGreaterThanZero() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .hasMessage("로또 번호는 1과 45 사이입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호는 46보다 작다")
    @Test
    void shouldBeLessThan46() {
        assertThatThrownBy(() -> new LottoNumber(47))
                .hasMessage("로또 번호는 1과 45 사이입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

}