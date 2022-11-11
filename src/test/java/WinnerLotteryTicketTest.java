import constant.Rank;
import domain.lottery.LotteryTicket;
import domain.lottery.WinnerLotteryTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerLotteryTicketTest {
    private LotteryTicket firstPrizeLotteryTicket;
    private LotteryTicket noPrizeLotteryTicket;
    private WinnerLotteryTicket matchedWinnerLotteryTicket;
    private WinnerLotteryTicket unmatchedWinnerLotteryTicket;

    @BeforeEach
    public void init() {
        firstPrizeLotteryTicket = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));
        noPrizeLotteryTicket = new LotteryTicket(List.of(11, 21, 31, 41, 15, 16));
        matchedWinnerLotteryTicket = new WinnerLotteryTicket(new LotteryTicket(List.of(1, 2, 3, 4, 5, 6)), 5);
        unmatchedWinnerLotteryTicket = new WinnerLotteryTicket(new LotteryTicket(List.of(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    @Order(1)
    public void 당첨등수확인_1등_당첨() {
        assertThat(matchedWinnerLotteryTicket.findRank(firstPrizeLotteryTicket)).isEqualTo(Rank.FIRST);
    }

    @Test
    @Order(2)
    public void 당첨등수확인_꼴등_당첨() {
        assertThat(unmatchedWinnerLotteryTicket.findRank(noPrizeLotteryTicket)).isEqualTo(Rank.UNKNOWN);
    }

    @Test
    @Order(3)
    public void 보너스번호일치여부_일치() {
        assertThat(matchedWinnerLotteryTicket.hasBonusTicketNumber(firstPrizeLotteryTicket)).isTrue();
    }

    @Test
    @Order(4)
    public void 보너스번호일치여부_불일치() {
        assertThat(unmatchedWinnerLotteryTicket.hasBonusTicketNumber(firstPrizeLotteryTicket)).isFalse();
    }
}
