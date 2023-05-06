package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 숫자 범위 예외 테스트")
    void number_exception() {
        assertThatThrownBy(() -> {
            LottoNumber.of(0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1보다 작은 값은 로또 번호가 될 수 없습니다.");
    }

    @Test
    @DisplayName("로또 숫자 캐시 테스트")
    void cache() {
        assertThat(LottoNumber.of(1) == LottoNumber.of(1)).isTrue();
    }
}
