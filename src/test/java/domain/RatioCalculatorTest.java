package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RatioCalculatorTest {

    @Test
    @DisplayName("수익률을 맞게 계산하는지 test")
    void calculateLottoRatio() {
        //given
        int purchasePrice = 100000;
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRankCount(Rank.FIFTH);
        lottoResult.addRankCount(Rank.FIFTH);

        //when,then
        assertThat(new RatioCalculator().calculateRatio(purchasePrice, lottoResult)).isEqualTo("0.10");
    }
}