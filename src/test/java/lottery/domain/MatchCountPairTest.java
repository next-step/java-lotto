package lottery.domain;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MatchCountPairTest {

    private final WinnerLottery WINNER_LOTTERY = new WinnerLottery(new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6)));
    private final ImmutableList<LotteryNumbers> LOTTERIES = ImmutableList.of(
            new LotteryNumbers(List.of(1, 2, 3, 10, 25, 45)),
            new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6)),
            new LotteryNumbers(List.of(9, 4, 12, 23, 29, 35))
    );

    private final MatchCountPair MATCH_PAIR = new MatchCountPair(WINNER_LOTTERY, LOTTERIES);

    @Test
    @DisplayName("맞춘 개수에 대한 건수를 증가시킨다.")
    void matchAll_test() {
        //then
        assertAll(
                () -> assertThat(MATCH_PAIR.countByRank(Rank.FOUR)).isEqualTo(1),
                () -> assertThat(MATCH_PAIR.countByRank(Rank.THIRD)).isEqualTo(0),
                () -> assertThat(MATCH_PAIR.countByRank(Rank.SECOND)).isEqualTo(0),
                () -> assertThat(MATCH_PAIR.countByRank(Rank.FIRST)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void calculateTotalProfit_test() {
        //when
        int jackpot = MATCH_PAIR.calculateTotalJackpot();

        //then
        assertThat(jackpot).isEqualTo(2000005000);
    }
}
