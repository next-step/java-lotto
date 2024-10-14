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

    @Test
    @DisplayName("getWinningAmount 메서드가 당첨 금액을 반환한다.")
    void getWinningAmountTest() {
        LottoWinningResult result = new LottoWinningResult(LottoWinningStatus.THREE);
        int winingCount = 2;
        for (int i=0; i<winingCount; i++) {
            result.increment();
        }
        assertThat(result.getWinningAmount()).isEqualTo(LottoWinningStatus.THREE.getAmount() * winingCount);
    }

    @Test
    @DisplayName("isWinningCountEqual 메서드가 매개변수와 당첨번호 개수가 같은지 비교 결과를 반환한다.")
    void isWinningCountEqualTest() {
        LottoWinningResult result = new LottoWinningResult(LottoWinningStatus.THREE);
        assertThat(result.isWinningCountEqual(3)).isTrue();
    }
}