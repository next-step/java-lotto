package lotto;


import lotto.match.LottoPrizeCount;
import lotto.match.LottoResult;
import lotto.prize.StandardPrizeRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoResultTest {

    private LottoResult lottoResult;
    private final int lottoPrice = 1000;

    @BeforeEach
    public void setUp() {
        List<LottoPrizeCount> lottoPrizeCountList = new ArrayList<>();
        lottoResult = new LottoResult(lottoPrizeCountList);
    }

    @Test
    @DisplayName("번돈과 소비한돈을 나누어 수익률을 반환한다.")
    public void getWinningPercentByEarningAndSpent() {
        assertThat(lottoResult.getWinningPercent(new StandardPrizeRate(), lottoPrice)).isEqualTo(5);
    }

}