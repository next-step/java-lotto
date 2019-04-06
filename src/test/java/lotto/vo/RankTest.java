package lotto.vo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RankTest {
    LotteryNumber winningNumber;

    @Before
    public void setUp() throws Exception {
        winningNumber =  new LotteryNumber(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 당첨_1등() {
        Rank rank = winningNumber.match(LotteryNumberTest.lottery1);
        assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
    }

    @Test
    public void 당첨_실패() {
        Rank rank = winningNumber.match(LotteryNumberTest.lottery2);
        assertThat(rank).isEqualTo(Rank.FAILURE);
    }

    @Test
    public void 당첨통계_4등() {
    }
}