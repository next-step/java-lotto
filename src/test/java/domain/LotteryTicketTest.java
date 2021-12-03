package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LotteryTicketTest {
    LotteryTicket lotteryTicket;
    WinningLottery winningLottery;

    @BeforeEach
    public void setup() {
        Set<LotteryNumber> lotteryNumber = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            lotteryNumber.add(new LotteryNumber(i));
        }

        lotteryTicket = new LotteryTicket(lotteryNumber);
        winningLottery = new WinningLottery(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 8)), 6);
    }

    @Test
    @DisplayName("로또번호 5개 당첨")
    public void matchLotteryTicket() {
        int rank = lotteryTicket.matchCount(winningLottery);
        assertThat(rank).isEqualTo(5);
    }

    @Test
    @DisplayName("보너스볼 당첨")
    public void matchBonusBall() {
        int rank = lotteryTicket.matchCount(winningLottery);
        assertThat(lotteryTicket.matchBonusBall(rank, winningLottery)).isEqualTo(1);
    }

}
