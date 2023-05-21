package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LotteryTicketsTest {

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

    @Test
    void 수동_로또_생성() {
        List<String> inputs = List.of("1, 2, 3, 4, 5, 6", "7, 8, 1, 2, 4, 33");

        assertThat(LotteryTickets.fromNumberList(inputs).size()).isEqualTo(2);
    }

    @Test
    void 수동_로또_생성_잘못된_입력형태() {
        List<String> inputs = List.of("1, 2, 3, 4,5,6", "7, 8, 1, 2, 4, 33");

        assertThatThrownBy(() -> LotteryTickets.fromNumberList(inputs).size())
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string:");
    }

    @Test
    void 수동_로또_생성_잘못된_갯수_입력() {
        List<String> inputs = List.of("1, 2, 3", "7, 8, 1, 2, 4, 33");

        assertThatThrownBy(() -> LotteryTickets.fromNumberList(inputs).size())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 로또 번호 목록입니다.");
    }

    @Test
    void addAll_테스트() {
        String stringA = "1, 2, 3, 4, 5, 6";
        String stringB = "7, 8, 1, 2, 4, 33";
        String stringC = "3, 4, 5, 6, 7, 8";
        String stringD = "13, 14, 5, 24, 26, 33";
        LotteryTickets lotteryTickets = LotteryTickets.fromNumberList(List.of(stringA, stringB));

        assertThat(lotteryTickets.addAll(LotteryTickets.fromNumberList(List.of(stringC, stringD))))
                .isEqualTo(LotteryTickets.fromNumberList(List.of(stringA, stringB, stringC, stringD)));

    }

}
