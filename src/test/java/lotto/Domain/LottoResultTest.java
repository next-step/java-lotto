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
        LottoResult lottoResult = LottoResult.init(new HashMap<>());

        assertThat(lottoResult.winLottoGradeAndPrize())
                .hasSize(6)
                .contains(entry(LottoGrade.MISS, 0)
                        , entry(LottoGrade.WIN5TH, 0)
                        , entry(LottoGrade.WIN4TH, 0)
                        , entry(LottoGrade.WIN3RD, 0)
                        , entry(LottoGrade.WIN2ND, 0)
                        , entry(LottoGrade.WIN1ST, 0));
    }

    @Test
    void revenueRateTest() {
        LottoResult lottoResult = LottoResult.init(new HashMap<>());
        lottoResult.put(LottoGrade.WIN1ST, 1);
        lottoResult.put(LottoGrade.WIN4TH, 1);
        lottoResult.put(LottoGrade.WIN4TH, 1);

        int lottoCount = 10;

        double result = lottoResult.revenueRate(lottoCount);

        assertThat(result).isEqualTo(2000100000.0);

    }
}
