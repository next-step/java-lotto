package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RankRecordTest {
    @DisplayName("sumOfPriceTest")
    @Test
    void sumOfPriceTest(){
        Map<Rank, Integer> recordPool = new HashMap<>();
        RankRecord rankRecord = new RankRecord(recordPool);

        recordPool.put(Rank.RANK_FIVE,1);
        recordPool.put(Rank.RANK_TWO,1);

        assertThat(rankRecord.sumOfPrice().getMoney()).isEqualTo(30_005_000);
    }

    @DisplayName("sumOfPriceTest2")
    @Test
    void sumOfPriceTest2(){
        RankRecord rankRecord = new RankRecord();

        rankRecord.getRecordPool().put(Rank.RANK_FIVE,3);

        assertThat(rankRecord.sumOfPrice().getMoney()).isEqualTo(15_000);
    }

    @Test
    void recordOfRankingsTest(){
        RankRecord rankRecord = new RankRecord();
        rankRecord.recordOfRankings(Rank.RANK_FIVE);
        rankRecord.recordOfRankings(Rank.RANK_FIVE);

        assertThat(rankRecord.getRecordPool().get(Rank.RANK_FIVE)).isEqualTo(2);
    }
}
