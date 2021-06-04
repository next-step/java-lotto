package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LotteriesTest {

    @Test
    @DisplayName("입력한 개수만큼 로또를 생성한다.")
    void generateLotteries_test() {
        //when
        Lotteries lotteries = new Lotteries(new GenerateCount(5), new MockNumberGenerator());

        //then
        assertThat(lotteries.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("생성된 로또들의 일치하는 개수에 대한 건수를 만든다.")
    void matchAllAndAddCounts_test() {
        //given
        Lotteries lotteries = new Lotteries(new GenerateCount(3), new MockNumberGenerator());
        WinnerLottery winnerLottery = new WinnerLottery(new LotteryNumbers(List.of(10, 2, 34, 4, 5, 6)));

        //when
        MatchCountPair pair = lotteries.matchAllAndAddCounts(winnerLottery);

        assertAll(
                () -> assertThat(pair.countByMatchCount(MatchCount.THREE)).isEqualTo(0),
                () -> assertThat(pair.countByMatchCount(MatchCount.FOUR)).isEqualTo(3),
                () -> assertThat(pair.countByMatchCount(MatchCount.FIVE)).isEqualTo(0),
                () -> assertThat(pair.countByMatchCount(MatchCount.SIX)).isEqualTo(0)
        );
    }
}
