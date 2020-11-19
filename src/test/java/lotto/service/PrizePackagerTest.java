package lotto.service;

import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.enums.PickType;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizePackagerTest {
    @Test
    void testAlwaysLose(){
        PrizePackager prizePackager = new DefaultPrizePackager();
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank rank = prizeInfo.checkRank(new Pick(PickType.AUTO, Arrays.asList(1,2,3,4,5,6)), Arrays.asList(1,2,3,4,5,6));

        assertThat(rank).isEqualTo(Rank.LOSE);

        Rank rank2 = prizeInfo.checkRank(new Pick(PickType.AUTO, Arrays.asList(1,2,3,4,5,6)), Arrays.asList(1,2,3,4,5,7));

        assertThat(rank2).isEqualTo(Rank.LOSE);
    }

    @Test
    void testAlwaysJackPot(){
        PrizePackager prizePackager = new JackPotPrizePackager();
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank rank = prizeInfo.checkRank(new Pick(PickType.AUTO, Arrays.asList(1,2,3,4,5,6)), Arrays.asList(1,2,3,4,5,6));

        assertThat(rank).isEqualTo(Rank.FIRST);

        Rank rank2 = prizeInfo.checkRank(new Pick(PickType.AUTO, Arrays.asList(1,2,3,4,5,6)), Arrays.asList(10,11,13,14,15,16));

        assertThat(rank2).isEqualTo(Rank.FIRST);
    }
}
