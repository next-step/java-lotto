package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("lottoResult 초기화 시 모든 랭크는 0이다")
    void result_init() {
        LottoResult result = new LottoResult();
        for (Rank rank : Rank.values()) {
            assertThat(result.getCount(rank)).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("6개가 일치하면, FIRST 랭크가 올라간다")
    void result_first() {
        LottoResult result = new LottoResult();
        result.addMatch(Rank.FIRST);
        assertThat(result.getCount(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("일치하지 않으면, None이 매칭된다")
    void result_none() {
        LottoResult result = new LottoResult();
        result.addMatch(Rank.NONE);
        assertThat(result.getCount(Rank.NONE)).isEqualTo(1);
    }

    @Test
    @DisplayName("3개 일치 시 당청금은 5000원이다")
    void getTotal() {
        LottoResult result = new LottoResult();
        result.addMatch(Rank.FIFTH);
        assertThat(result.getTotal()).isEqualTo(5000);
    }
}