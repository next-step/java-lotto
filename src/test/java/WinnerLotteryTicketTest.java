import constant.Rank;
import domain.lottery.LotteryNumber;
import domain.lottery.LotteryTicket;
import domain.lottery.WinnerLotteryTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerLotteryTicketTest {
    private WinnerLotteryTicket matchedWinnerLotteryTicket;
    private WinnerLotteryTicket unmatchedWinnerLotteryTicket;

    @BeforeEach
    public void init() {
        matchedWinnerLotteryTicket = new WinnerLotteryTicket(LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(6))), LotteryNumber.of(11));
        unmatchedWinnerLotteryTicket = new WinnerLotteryTicket(LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(6))), LotteryNumber.of(7));
    }

    @Test
    @Order(0)
    public void 당첨번호확인_당첨번호_보너스번호_중복() {
        assertThatThrownBy(
                () -> new WinnerLotteryTicket(LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                        LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(6))), LotteryNumber.of(3))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호와 보너스 번호가 중복됩니다.");
    }

    @Test
    @Order(1)
    public void 당첨번호확인_보너스번호_1미만() {
        assertThatThrownBy(
                () -> new WinnerLotteryTicket(LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                        LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(6))), LotteryNumber.of(0))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 번호입니다.");
    }

    @Test
    @Order(2)
    public void 당첨번호확인_보너스번호_45초과() {
        assertThatThrownBy(
                () -> new WinnerLotteryTicket(LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                        LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(6))), LotteryNumber.of(46))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 번호입니다.");
    }

    @Test
    @Order(3)
    public void 당첨등수확인_1등_당첨() {
        LotteryTicket firstPrizeLotteryTicket = LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(6)));
        assertThat(matchedWinnerLotteryTicket.findRank(firstPrizeLotteryTicket)).isEqualTo(Rank.FIRST);
    }

    @Test
    @Order(4)
    public void 당첨등수확인_2등_당첨() {
        LotteryTicket secondPrizeLotteryTicket = LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                LotteryNumber.of(4), LotteryNumber.of(6), LotteryNumber.of(10)));
        assertThat(matchedWinnerLotteryTicket.findRank(secondPrizeLotteryTicket)).isEqualTo(Rank.SECOND);
    }

    @Test
    @Order(5)
    public void 당첨등수확인_2등_보너스번호_당첨() {
        LotteryTicket secondPrizeWithBonusLotteryTicket = LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                LotteryNumber.of(4), LotteryNumber.of(6), LotteryNumber.of(11)));
        assertThat(matchedWinnerLotteryTicket.findRank(secondPrizeWithBonusLotteryTicket)).isEqualTo(Rank.SECOND_WITH_BONUS);
    }


    @Test
    @Order(6)
    public void 당첨등수확인_꼴등_당첨() {
        LotteryTicket noPrizeLotteryTicket = LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(11), LotteryNumber.of(12), LotteryNumber.of(13),
                LotteryNumber.of(14), LotteryNumber.of(15), LotteryNumber.of(17)));
        assertThat(unmatchedWinnerLotteryTicket.findRank(noPrizeLotteryTicket)).isEqualTo(Rank.UNKNOWN);
    }

    @Test
    @Order(7)
    public void 보너스번호일치여부_일치() {
        LotteryTicket withBonusNumber = LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(11), LotteryNumber.of(21), LotteryNumber.of(31),
                LotteryNumber.of(41), LotteryNumber.of(12), LotteryNumber.of(22)));
        assertThat(matchedWinnerLotteryTicket.hasBonusTicketNumber(withBonusNumber)).isTrue();
    }

    @Test
    @Order(8)
    public void 보너스번호일치여부_불일치() {
        LotteryTicket withoutBonusNumber = LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(17), LotteryNumber.of(27), LotteryNumber.of(37),
                LotteryNumber.of(18), LotteryNumber.of(28), LotteryNumber.of(38)));
        assertThat(unmatchedWinnerLotteryTicket.hasBonusTicketNumber(withoutBonusNumber)).isFalse();
    }
}
