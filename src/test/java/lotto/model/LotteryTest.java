package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTest {

    @Test
    void 금액을_입력하면_로또티켓목록을_생성() {
        int money = 14000;
        LotteryTickets lotteryTickets = LotteryTickets.of(money, new AutoLotteryNumberGenerator());
        assertThat(lotteryTickets.size()).isEqualTo(14);
    }

    @Test
    void 금액이_나누어떨어지지_않으면_버림() {
        int money = 14500;
        LotteryTickets lotteryTickets = LotteryTickets.of(money, new AutoLotteryNumberGenerator());
        assertThat(lotteryTickets.size()).isEqualTo(14);
    }

    @Test
    void 로또_티켓은_여섯개의_랜덤숫자를_포함() {
        LotteryTicket lotteryTicket = LotteryTicket.of(new AutoLotteryNumberGenerator());
        assertThat(lotteryTicket.size()).isEqualTo(6);
    }

    @Test
    void 로또_티켓은_중복번호를_가지지않음() {
        assertThatThrownBy(() -> new LotteryTicket(Set.of(
                LotteryNumber.of(8),
                LotteryNumber.of(21),
                LotteryNumber.of(21),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("duplicate element: 21");
    }

    @Test
    void 로또티켓_맞는갯수_계산() {
        LotteryTicket lotteryTicket = new LotteryTicket(Set.of(
                LotteryNumber.of(8),
                LotteryNumber.of(21),
                LotteryNumber.of(23),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43)));
        Set<Integer> winNumbers = Set.of(41, 1, 13, 27, 42, 43);
        int count = lotteryTicket.matchCount(new WinNumbers(winNumbers));
        assertThat(count).isEqualTo(3);
    }

    @Test
    void 총_당첨_금액() {
        Map<Win, Integer> winTotal = new EnumMap<>(Win.class);
        winTotal.put(Win.WIN_3, 3);
        winTotal.put(Win.WIN_4, 4);
        winTotal.put(Win.WIN_5, 0);
        winTotal.put(Win.WIN_6, 1);
        assertThat(Win.totalMoney(winTotal)).isEqualTo(2000215000);
    }

    @Test
    void 수익률_계산() {
        int income = 5000;
        int outcome = 14000;
        assertThat(Win.calculateProfitRate(income, outcome)).isEqualTo("0.35");
    }

}
