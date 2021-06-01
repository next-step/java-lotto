package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LotteryFactoryTest {

    @Test
    @DisplayName("생성된 로또들의 일치하는 개수에 대한 건수를 만든다.")
    void matchAll_test() {
        //given
        Lotteries lotteries = new Lotteries(new GenerateCount(3), new MockNumberGenerator());
        WinnerLottery winnerLottery = new WinnerLottery(new LotteryNumbers(List.of(10, 2, 34, 4, 5, 6)));
        LotteryFactory lotteryFactory = new LotteryFactory();

        //when
        MatchCountPair pair = lotteryFactory.matchAll(lotteries, winnerLottery);

        assertAll(
                () -> assertThat(pair.countByMatchCount(MatchCount.THREE)).isEqualTo(0),
                () -> assertThat(pair.countByMatchCount(MatchCount.FOUR)).isEqualTo(3),
                () -> assertThat(pair.countByMatchCount(MatchCount.FIVE)).isEqualTo(0),
                () -> assertThat(pair.countByMatchCount(MatchCount.SIX)).isEqualTo(0)
        );
    }
}
