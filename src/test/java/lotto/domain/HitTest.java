package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HitTest {

    @Test
    @DisplayName("3개 이상 당첨됐을경우 당첨개수가 1회 증가한다.")
    void hittingLottoStatistics() {
        Hit hit = new Hit();
        hit.hittingLottoStatistics(3);
        Map<Statistics, Integer> resultHit = hit.getHit();

        assertThat(resultHit.get(Statistics.THREE)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 총 금액 구하기")
    void getTotalWinningAmount() {
        Hit hit = new Hit();
        hit.hittingLottoStatistics(3);

        assertThat(hit.getTotalWinningAmount()).isEqualTo(5000);
    }
}