package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RankGroupTest {
    private RankGroup rankGroup;

    @BeforeEach
    public void setup() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        LotteryTicket lotteryTicket = new LotteryTicket(numbers);
        List<LotteryTicket> lotteryTickets = Arrays.asList(lotteryTicket);
        LastWeekLotteryNumber lastWeekLottery = new LastWeekLotteryNumber(new HashSet<>(Arrays.asList(1,2,3,4,8,9)));
        rankGroup = new RankGroup(new LotteryTickets(lotteryTickets), lastWeekLottery);
    }

    @Test
    @DisplayName("당첨 등수 확인 (4개 당엄으로 3등이 나와야 한다.)")
    public void rankingCheck() {
        assertThat(rankGroup.value(0)).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨개수 3개 미만은 꽝으로 0이 나온다.")
    public void checkLotteryFailed() {
        assertThat(RankGroup.getRank(2).value()).isEqualTo(0);
    }
}
