package lotto.vo;

import lotto.utils.ConstTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RankTest {
    LotteryNumber winningNumber;

    @Before
    public void setUp() {
        //Given
        winningNumber = new LotteryNumber(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    public void 당첨_1등() {
        //When
        Rank rank = winningNumber.match(ConstTest.LOTTERY_NUMBER_DEFAULT);

        //Then
        assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
    }

    @Test
    public void 당첨_2등() {
        //When
        Rank rank = winningNumber.match(ConstTest.LOTTERY_ACCORDANCE_FIVE_HAS_BONUS);

        //Then
        assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    public void 당첨_실패() {
        //When
        Rank rank = winningNumber.match(ConstTest.LOTTERY_ACCORDANCE_TWO);

        //Then
        assertThat(rank).isEqualTo(Rank.FAILURE);
    }
}