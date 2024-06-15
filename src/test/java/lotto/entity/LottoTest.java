package lotto.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static lotto.entity.Lotto.LOTTO_NUMBERS_ARE_6_NUMBER;
import static lotto.entity.Lotto.LOTTO_NUMBERS_ARE_NUMBERS_1_TO_45;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void lotto() {
        var lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers().size())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("로또는 6개의 숫자만 가져야 한다.")
    void illegal_lotto1() {
        assertThatThrownBy(() -> {
            new Lotto(Set.of(1, 2, 3, 4, 5, 6, 7));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBERS_ARE_6_NUMBER);
    }

    @Test
    @DisplayName("로또는 6개의 숫자만 가져야 한다.")
    void illegal_lotto2() {
        assertThatThrownBy(() -> {
            new Lotto(Set.of(1, 2, 3, 4, 5));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBERS_ARE_6_NUMBER);
    }

    @Test
    @DisplayName("로또는 1~45의 숫자만 가져야 한다.")
    void illegal_lotto3() {
        assertThatThrownBy(() -> {
            new Lotto(Set.of(0, 2, 3, 4, 5, 46));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBERS_ARE_NUMBERS_1_TO_45);
    }
}