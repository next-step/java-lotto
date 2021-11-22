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
        LotteryTicket lotteryTicket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LastWeekLottery lastWeekLottery = new LastWeekLottery(new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
        moneyPrize = new MoneyPrize(new RankGroup(lotteryTicket, lastWeekLottery, 0));
    }

    @Test
    @DisplayName("당첨 등수 상금 확인")
    public void checkWinningPrize() {
        assertThat(moneyPrize.value(0)).isEqualTo(50000);
    }

}
