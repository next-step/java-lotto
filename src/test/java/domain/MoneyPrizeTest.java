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
        List<LotteryNumber> lotteryNumber = new ArrayList<>();
        for(int i=1; i<=6; i++){
            lotteryNumber.add(new LotteryNumber(i));
        }

        LotteryTicket lotteryTicket = new LotteryTicket(lotteryNumber);
        WinningLottery lastWeekLottery = new WinningLottery(new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8)), 0);
        moneyPrize = new MoneyPrize(new RankGroup(lotteryTicket, lastWeekLottery));
    }

    @Test
    @DisplayName("당첨 등수 상금 확인")
    public void checkWinningPrize() {
        assertThat(moneyPrize.value(0)).isEqualTo(50000);
    }

}
