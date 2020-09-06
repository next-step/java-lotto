package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankRecordTest {
    @DisplayName("sumOfPriceTest")
    @Test
    void sumOfPriceTest(){
        RankRecord rankRecord = new RankRecord();

        rankRecord.getRecordPool().put(Rank.RANK_FIVE,1);
        rankRecord.getRecordPool().put(Rank.RANK_TWO,1);

        assertThat(rankRecord.sumOfPrice().getMoney()).isEqualTo(30_005_000);
    }

    @DisplayName("sumOfPriceTest2")
    @Test
    void sumOfPriceTest2(){
        RankRecord rankRecord = new RankRecord();

        rankRecord.getRecordPool().put(Rank.RANK_FIVE,3);

        assertThat(rankRecord.sumOfPrice().getMoney()).isEqualTo(15_000);
    }
}
