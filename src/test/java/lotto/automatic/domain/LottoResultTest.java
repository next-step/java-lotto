package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("결과 생성 확인")
    public void createLottoResult() {

        LottoResult result = new LottoResult(10000, Arrays.asList(
                LottoRank.FIRST, LottoRank.THIRD
        ));

        assertThat(result.getRankCount(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(result.getRankCount(LottoRank.FIRST)).isEqualTo(1);

    }

    @Test
    @DisplayName("수익률 확인")
    public void earning_rate() {

        LottoResult result = new LottoResult(10000, Arrays.asList(
                LottoRank.SECOND, LottoRank.MISS
        ));

        BigDecimal earningRate = result.calculateEarningRate();
        assertThat(earningRate.floatValue()).isEqualTo((float)LottoRank.FIRST.getEarningMoney() / 10000 );

    }


}