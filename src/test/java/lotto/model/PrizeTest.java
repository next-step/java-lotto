package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @Test
    @DisplayName("로또 숫자 일치 개수에 따른 상금을 올바르게 반환한다.")
    void fromMatchCount() {
        assertThat(Prize.valueOf(2, false)).isEqualTo(Prize.MISS);
        assertThat(Prize.valueOf(5, false)).isEqualTo(Prize.THIRD);
        assertThat(Prize.valueOf(5, true)).isEqualTo(Prize.SECOND);
        assertThat(Prize.valueOf(6, false)).isEqualTo(Prize.FIRST);
    }
}