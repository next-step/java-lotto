package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyPrizeTest {
    private MoneyPrize moneyPrize;

    @BeforeEach
    public void setup() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }

        LotteryTicket lotteryTicket = new LotteryTicket(numbers);
        List<LotteryTicket> lotteryTickets = Arrays.asList(lotteryTicket);
        LastWeekLotteryNumber lastWeekLottery = new LastWeekLotteryNumber(new HashSet<>(Arrays.asList(1,2,3,4,7,8)));
        moneyPrize = new MoneyPrize(new RankGroup(new LotteryTickets(lotteryTickets), lastWeekLottery));
    }

    @Test
    @DisplayName("당첨 등수 상금 확인")
    public void checkWinningPrize() {
        assertThat(moneyPrize.value(3)).isEqualTo(50000);
    }

}
