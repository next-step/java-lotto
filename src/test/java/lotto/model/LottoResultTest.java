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
    @DisplayName("당첨 통계에 낙점된 경우를 추가한다.")
    public void test2() {
        var lottoResult = new LottoResult();

        lottoResult.addRank(LottoRank.BAD);
        assertThat(lottoResult.getCount(LottoRank.BAD))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률을 반환한다.")
    public void test3() {
        var lottoResult = new LottoResult();

        // 티켓 2개 구입
        lottoResult.addRank(LottoRank.THREE);
        lottoResult.addRank(LottoRank.BAD);

        assertThat(lottoResult.getProfitRate())
                .isEqualTo(2.50);
    }
}