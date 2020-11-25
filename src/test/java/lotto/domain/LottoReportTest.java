package lotto.domain;

import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoReportTest {

    @Test
    void testGetRankMap(){
        LottoReport lottoReport = new LottoReport(new Cash(10000L, Currency.WON));
        lottoReport.addRanks(Rank.FIRST);
        Map<Rank, Integer> rankMap = lottoReport.getRankMap();
        assertThat(rankMap).extractingByKey(Rank.FIRST).isEqualTo(1);
    }

    @Test
    void testGetEarningRate(){
        LottoReport lottoReport = new LottoReport(new Cash(2000L, Currency.WON));
        lottoReport.addEarnings(new Cash(1000L, Currency.WON));
        lottoReport.addEarnings(new Cash(5000L, Currency.WON));

        BigDecimal earningRate = lottoReport.getEarningRate();
        assertThat(earningRate).isCloseTo(BigDecimal.valueOf(3), Percentage.withPercentage(100));
    }

    @ParameterizedTest
    @CsvSource(value = {"2000,이득","6000,본전","8000,손해"})
    void testGetEarningType(Long cost, String result){
        LottoReport lottoReport = new LottoReport(new Cash(cost,Currency.WON));
        lottoReport.addEarnings(new Cash(1000L, Currency.WON));
        lottoReport.addEarnings(new Cash(5000L, Currency.WON));

        assertThat(lottoReport.getEarningRateType().getDescription()).isEqualTo(result);
    }
}
