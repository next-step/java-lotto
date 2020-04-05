package lotto.Domain;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class LottoResultTest {

    @Test
    void initLottoStatisticsTest() {
        LottoResult lottoResult = LottoResult.init();

        assertThat(lottoResult.winLottoGradeAndPrize())
                .contains(entry(LottoGrade.MISS, 0)
                        , entry(LottoGrade.WIN5TH, 0)
                        , entry(LottoGrade.WIN4TH, 0)
                        , entry(LottoGrade.WIN3RD, 0)
                        , entry(LottoGrade.WIN2ND, 0)
                        , entry(LottoGrade.WIN1ST, 0));
    }

    @Test
    void revenueRateTest() {
        LottoResult lottoResult = LottoResult.init();
        lottoResult.addWinGrade(LottoGrade.WIN1ST);
        lottoResult.addWinGrade(LottoGrade.WIN4TH);
        lottoResult.addWinGrade(LottoGrade.WIN4TH);

        double result = lottoResult.revenueRate();

        assertThat(result).isEqualTo(666700.0);

    }
}
