package lotto.domain;

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
    void testGetCost(){
        LottoReport lottoReport = new LottoReport();
        lottoReport.setCost(2000L);

        assertThat(lottoReport.getCost()).isEqualTo(2000L);
    }

    @Test
    void testGetTotalEarnings(){
        LottoReport lottoReport = new LottoReport();
        lottoReport.addEarnings(1000L);
        lottoReport.addEarnings(5000L);
        Long totalEarnings = lottoReport.getTotalEarnings();

        assertThat(totalEarnings).isEqualTo(6000L);
    }

    @Test
    void testGetRankMap(){
        LottoReport lottoReport = new LottoReport();
        lottoReport.addRanks(Rank.FIRST);
        Map<Rank, Integer> rankMap = lottoReport.getRankMap();
        assertThat(rankMap).extractingByKey(Rank.FIRST).isEqualTo(1);
    }

    @Test
    void testGetEarningRate(){
        LottoReport lottoReport = new LottoReport();
        lottoReport.setCost(2000L);
        lottoReport.addEarnings(1000L);
        lottoReport.addEarnings(5000L);

        BigDecimal earningRate = lottoReport.getEarningRate();
        assertThat(earningRate).isCloseTo(BigDecimal.valueOf(3), Percentage.withPercentage(100));
    }

    @ParameterizedTest
    @CsvSource(value = {"2000,이득","6000,본전","8000,손해"})
    void testGetEarningDescription(Long cost, String result){
        LottoReport lottoReport = new LottoReport();
        lottoReport.setCost(cost);
        lottoReport.addEarnings(1000L);
        lottoReport.addEarnings(5000L);

        assertThat(lottoReport.getEarningRateDescription()).isEqualTo(result);
    }
}
