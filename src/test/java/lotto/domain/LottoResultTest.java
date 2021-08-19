package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("LottoRankList에따라서 결과가 생성된다.")
    @Test
    void get_result_test() {
        LottoResult lottoResult = new LottoResult(Collections.singletonList(LottoRank.FIRST));
        assertThat(lottoResult.getResult().get(LottoRank.FIRST)).isEqualTo(1);
    }

    @DisplayName("당첨 결과에 따라서 이익률이 계산된다.")
    @Test
    void get_profit_rate_test() {
        int price = 1000;
        LottoResult lottoResult = new LottoResult(Collections.singletonList(LottoRank.FIRST));
        assertThat(lottoResult.getProfitRate(price)).isEqualTo((double) LottoRank.FIRST.getPrice()/price);
    }

    @DisplayName("우승 상금을 계산한다")
    @Test
    void calculate_winning_price() {
        LottoResult lottoResult = new LottoResult(Collections.singletonList(LottoRank.FIRST));
        assertThat(lottoResult.calculateWinningPrice()).isEqualTo(LottoRank.FIRST.getPrice());
    }
}
