package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("당첨 결과를 추가하면 해당 결과의 개수가 증가한다.")
    @Test
    void add() {
        // given
        LottoResult lottoResult = new LottoResult();

        // when
        lottoResult.add(3);
        lottoResult.add(3);
        lottoResult.add(4);

        // then
        assertThat(lottoResult.getMatchCount(3)).isEqualTo(2);
        assertThat(lottoResult.getMatchCount(4)).isEqualTo(1);
    }

    @DisplayName("일치하는 번호가 3개 미만이면 해당 결과의 개수가 증가하지 않는다.")
    @Test
    void addLessThanThree() {
        // given
        LottoResult lottoResult = new LottoResult();

        // when
        lottoResult.add(2);

        // then
        assertThat(lottoResult.getMatchCount(2)).isEqualTo(0);
    }

    @DisplayName("당첨금을 계산한다.")
    @Test
    void calculateTotalPrize() {
        // given
        LottoResult lottoResult = new LottoResult();
        lottoResult.add(3);
        lottoResult.add(4);
        lottoResult.add(5);
        lottoResult.add(6);

        // when
        long totalPrize = lottoResult.calculateTotalPrize();

        // then
        long expected = 5_000 + 50_000 + 1_500_000 + 2_000_000_000;
        assertThat(totalPrize).isEqualTo(expected);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        LottoResult lottoResult = new LottoResult();
        lottoResult.add(3); // 5,000원

        // when
        double profitRate = lottoResult.calculateProfitRate(1000);

        // then
        assertThat(profitRate).isEqualTo(5.0);
    }
}
