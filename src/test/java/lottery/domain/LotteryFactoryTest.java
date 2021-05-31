package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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
        Map<Integer, Integer> matchCounts = lotteryFactory.matchAll(lotteries, winnerLottery);

        assertAll(
                () -> assertThat(matchCounts.get(3)).isEqualTo(0),
                () -> assertThat(matchCounts.get(4)).isEqualTo(3),
                () -> assertThat(matchCounts.get(5)).isEqualTo(0),
                () -> assertThat(matchCounts.get(6)).isEqualTo(0)
        );
    }
}
