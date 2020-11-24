package lotto.service;

import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.enums.PickType;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizePackagerTest {
    private final AbstractPrizePackager prizePackager = new LottoPrizePackager();
    private Pick testPick;

    @BeforeEach
    void makeTestPick(){
        testPick = new Pick(PickType.AUTO, Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void testFirstPrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank first = prizeInfo.checkRank(testPick, Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(first).isEqualTo(Rank.FIRST);
    }

    @Test
    void testThirdPrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank third = prizeInfo.checkRank(testPick, Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(third).isEqualTo(Rank.THIRD);
    }

    @Test
    void testFourthPrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank fourth = prizeInfo.checkRank(testPick, Arrays.asList(1, 2, 3, 4, 7, 8));
        assertThat(fourth).isEqualTo(Rank.FOURTH);
    }

    @Test
    void testFifthPrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank fifth = prizeInfo.checkRank(testPick, Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(fifth).isEqualTo(Rank.FIFTH);
    }

    @Test
    void testLosePrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank lose = prizeInfo.checkRank(testPick, Arrays.asList(1, 2, 7, 8, 9, 10));
        assertThat(lose).isNull();
    }
}
