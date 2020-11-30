package lotto.automatic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @BeforeEach
    void setUp() {
//        this.result = new LottoResult(Arrays.asList(
//                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
//                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
//        ), new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("결과 생성 확인")
    public void createLottoResult() {

        LottoResult result = new LottoResult(10000, Arrays.asList(
                LottoRank.FIRST, LottoRank.SECOND
        ));

        assertThat(result.getRankCount(LottoRank.FORTH)).isEqualTo(0);
        assertThat(result.getRankCount(LottoRank.FIRST)).isEqualTo(1);

    }

    @Test
    @DisplayName("수익률 확인")
    public void earning_rate() {

        LottoResult result = new LottoResult(10000, Arrays.asList(
                LottoRank.FIRST, LottoRank.NONE
        ));


        BigDecimal earningRate = result.calculateEarningRate();
        assertThat(earningRate.floatValue()).isEqualTo((float)LottoRank.FIRST.earningMoney / 10000 );

    }


}