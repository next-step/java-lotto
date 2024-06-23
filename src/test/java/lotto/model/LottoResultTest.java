package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    @DisplayName("당첨 통계에 당첨된 등수를 추가한다.")
    public void test1() {
        var lottoResult = new LottoResult();

        lottoResult.addRank(LottoRank.THREE);
        assertThat(lottoResult.getCount(LottoRank.THREE))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률을 반환한다.")
    public void test2() {
        var lottoResult = new LottoResult();
        var totalTicketCost = 14000; // 티켓 14개 구입

        lottoResult.addRank(LottoRank.THREE);

        assertThat(lottoResult.getProfitRate(totalTicketCost))
                .isEqualTo(0.35);
    }
}