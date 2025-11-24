package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @Test
    @DisplayName("일치 개수로 상금을 올바르게 반환한다.")
    void fromMatchCount() {
        assertThat(Prize.fromMatchCount(3)).isEqualTo(Prize.THREE_MATCHES);
        assertThat(Prize.fromMatchCount(4)).isEqualTo(Prize.FOUR_MATCHES);
        assertThat(Prize.fromMatchCount(5)).isEqualTo(Prize.FIVE_MATCHES);
        assertThat(Prize.fromMatchCount(6)).isEqualTo(Prize.SIX_MATCHES);
    }
}