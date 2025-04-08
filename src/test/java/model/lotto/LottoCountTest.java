package model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoCountTest {
    @Test
    @DisplayName("금액보다 더 많이 수동 로또를 발급하면 에러가 발생된다.")
    public void checkValidLottoCounts() {
        assertThatThrownBy(() -> new LottoCount(2, 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액/1000한 횟수에서 수동 로또를 빼면 자동 로또 개수가 된다.")
    void getAutoCount() {
        LottoCount lottoCount = new LottoCount(2, 1);
        assertEquals(lottoCount.getAutoLottoCount(), 1);
    }
}