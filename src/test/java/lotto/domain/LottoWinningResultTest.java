package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningResultTest {
    @Test
    @DisplayName("increment 메서드가 count를 1씩 증가시킨다.")
    void incrementTest() {
        LottoWinningResult result = new LottoWinningResult(LottoWinningStatus.THREE);
        result.increment();
        result.increment();
        assertThat(result.getCount()).isEqualTo(2);
    }
}