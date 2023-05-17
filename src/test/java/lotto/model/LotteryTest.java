package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTest {

    @Test
    void 금액을_입력하면_로또티켓목록을_생성() {
        int money = 14000;
        LotteryTickets lotteryTickets = LotteryTickets.fromMoney(money, new AutoLotteryNumberGenerator());
        assertThat(lotteryTickets.size()).isEqualTo(14);
    }

    @Test
    void 금액이_나누어떨어지지_않으면_버림() {
        int money = 14500;
        LotteryTickets lotteryTickets = LotteryTickets.fromMoney(money, new AutoLotteryNumberGenerator());
        assertThat(lotteryTickets.size()).isEqualTo(14);
    }

    @Test
    void 로또_티켓은_여섯개의_랜덤숫자를_포함() {
        LotteryTicket lotteryTicket = LotteryTicket.of(new AutoLotteryNumberGenerator());
        assertThat(lotteryTicket.size()).isEqualTo(6);
    }

    @Test
    void 로또_숫자_범위를_벗어나면_에러() {
        assertThatThrownBy(() -> LotteryNumber.of(44))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 로또 번호입니다.");
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
        double count = lotteryTicket.matchCount(new WinNumbers(winNumbers));
        assertThat(count).isEqualTo(3);
    }

    @Test
    void 우승_통계_계산() {
        LotteryTicket win3 = new LotteryTicket(Set.of(
                LotteryNumber.of(8),
                LotteryNumber.of(21),
                LotteryNumber.of(23),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43)));
        LotteryTicket win4 = new LotteryTicket(Set.of(
                LotteryNumber.of(1),
                LotteryNumber.of(13),
                LotteryNumber.of(42),
                LotteryNumber.of(43),
                LotteryNumber.of(2),
                LotteryNumber.of(9)));
        LotteryTicket win5 = new LotteryTicket(Set.of(
                LotteryNumber.of(41),
                LotteryNumber.of(1),
                LotteryNumber.of(13),
                LotteryNumber.of(2),
                LotteryNumber.of(43),
                LotteryNumber.of(27)));
        LotteryTicket win6 = new LotteryTicket(Set.of(
                LotteryNumber.of(41),
                LotteryNumber.of(1),
                LotteryNumber.of(13),
                LotteryNumber.of(42),
                LotteryNumber.of(43),
                LotteryNumber.of(27)));
        LotteryTicket win6_2 = new LotteryTicket(Set.of(
                LotteryNumber.of(41),
                LotteryNumber.of(1),
                LotteryNumber.of(13),
                LotteryNumber.of(42),
                LotteryNumber.of(43),
                LotteryNumber.of(27)));
        LotteryTicket miss = new LotteryTicket(Set.of(
                LotteryNumber.of(41),
                LotteryNumber.of(1),
                LotteryNumber.of(2),
                LotteryNumber.of(3),
                LotteryNumber.of(4),
                LotteryNumber.of(5)));
        LotteryTickets lotteryTickets = new LotteryTickets(List.of(win3, win4, win5, win6, win6_2, miss));
        WinNumbers winNumbers = new WinNumbers(Set.of(41, 1, 13, 27, 42, 43));
        Map<Win, Integer> totalWin = lotteryTickets.getTotalWin(winNumbers);
        assertThat(totalWin).containsEntry(Win.WIN_3, 1)
                .containsEntry(Win.WIN_4, 1)
                .containsEntry(Win.WIN_5, 1)
                .containsEntry(Win.WIN_6, 2)
                .containsEntry(Win.DEFAULT, 1);
    }

    @Test
    void 다섯개와_보너스볼_일치는_이등() {
        LotteryTicket lotteryTicket = new LotteryTicket(Set.of(
                LotteryNumber.of(27),
                LotteryNumber.of(1),
                LotteryNumber.of(10),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43)));
        WinNumbers winNumbers = new WinNumbers(Set.of(41, 1, 13, 27, 42, 43), 10);
        assertThat(lotteryTicket.matchCount(winNumbers)).isEqualTo(5.5);
    }

    @Test
    void 이등_통계_계산() {
        LotteryTicket lotteryTicket = new LotteryTicket(Set.of(
                LotteryNumber.of(27),
                LotteryNumber.of(1),
                LotteryNumber.of(10),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43)));
        LotteryTickets lotteryTickets = new LotteryTickets(List.of(lotteryTicket));
        WinNumbers winNumbers = new WinNumbers(Set.of(41, 1, 13, 27, 42, 43), 10);
        Map<Win, Integer> totalWin = lotteryTickets.getTotalWin(winNumbers);
        assertThat(totalWin).containsEntry(Win.WIN_5_BONUS, 1);
    }

    @Test
    void toString_정렬() {
        LotteryTicket lotteryTicket = new LotteryTicket(Set.of(
                LotteryNumber.of(27),
                LotteryNumber.of(1),
                LotteryNumber.of(10),
                LotteryNumber.of(41),
                LotteryNumber.of(42),
                LotteryNumber.of(43)));
        assertThat(lotteryTicket).hasToString("[1, 10, 27, 41, 42, 43]");
    }

    @Test
    void 수동구매_로또수가_돈을_초과하면_에러() {
        int manualLotteryTicketCount = 3;
        int money = 1500;

        assertThatThrownBy(() -> LotteryTickets.fromMoney(money, manualLotteryTicketCount, new AutoLotteryNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지불한 돈 이상으로 구매할 수 없습니다.");
    }

    @Test
    void 자동으로_구매하는_티켓수_계산() {
        int manualLotteryTicketCount = 3;
        int money = 14000;

        LotteryTickets autoLotteryTickets = LotteryTickets.fromMoney(money, manualLotteryTicketCount, new AutoLotteryNumberGenerator());
        assertThat(autoLotteryTickets.size()).isEqualTo(11);
    }

    @Test
    void 자동으로_구매하는_티켓수_계산_나누어떨어지지_않음() {
        int manualLotteryTicketCount = 3;
        int money = 14300;

        LotteryTickets autoLotteryTickets = LotteryTickets.fromMoney(money, manualLotteryTicketCount, new AutoLotteryNumberGenerator());
        assertThat(autoLotteryTickets.size()).isEqualTo(11);
    }

}
