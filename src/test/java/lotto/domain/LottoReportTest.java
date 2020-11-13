package lotto.domain;

import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

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
        assertThat(earningRate).isEqualTo(BigDecimal.valueOf(3));
    }
}
