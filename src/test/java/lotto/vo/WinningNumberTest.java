package lotto.vo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class WinningNumberTest {
    Lottery userLottery;

    @Before
    public void setUp() throws Exception {
        userLottery =  Lottery.toLotteries(Arrays.asList(1, 2, 3, 4, 5, 7));
    }

    @Test
    public void 당첨_1등() {
        WinningNumber winningNumber = new WinningNumber(Lottery.toLotteries(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Rank rank = winningNumber.match(userLottery);
        assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
    }

    @Test
    public void 당첨_실패() {
        WinningNumber winningNumber = new WinningNumber(Lottery.toLotteries(Arrays.asList(1, 12, 13, 14, 15, 8)));
        Rank rank = winningNumber.match(userLottery);
        assertThat(rank).isEqualTo(Rank.FAILURE);
    }
}