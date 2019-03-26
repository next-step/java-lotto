package lottery.machine;

import lottery.domain.*;
import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {

    @Test
    public void test_로또_구매_only_랜덤번호() {
        LotteryMachine machine = new LotteryMachine();
        Money price = Money.valueOf(14000);

        assertThat(machine.buyLotteryTicket(price))
                .hasSize(14);
    }

    @Test
    public void test_로또_구매_only_지정번호() {
        LotteryMachine machine = new LotteryMachine();
        List<LotteryTicket> selectedTickets = createSelectedTickets(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12));
        Money price = Money.valueOf(2000);

        assertThat(machine.buyLotteryTicket(price, selectedTickets))
                .hasSize(2)
                .containsAll(selectedTickets);
    }

    @Test
    public void test_로또_구매_지정번호_with_랜덤번호() {
        LotteryMachine machine = new LotteryMachine();
        List<LotteryTicket> selectedTickets = createSelectedTickets(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12));

        Money price = Money.valueOf(14000);
        assertThat(machine.buyLotteryTicket(price, selectedTickets))
            .hasSize(14)
            .containsAll(selectedTickets);
    }

    @Test
    public void test_로또_구매_지정번호_당첨_1등_2개() {
        LotteryMachine machine = new LotteryMachine();
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        List<LotteryTicket> selectedTickets = createSelectedTickets(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6));

        machine.buyLotteryTicket(Money.valueOf(2000), selectedTickets);
        LotteryWinningStatistics statistics = machine.raffle(winningTicket);

        assertThat(statistics.countRank(LotteryRank.FIRST))
                .isEqualTo(TicketCount.valueOf(2));
    }

    private List<LotteryTicket> createSelectedTickets(List<Integer> ...numbers) {
        return Arrays.asList(numbers)
                .stream()
                .map(LotteryTicket::new)
                .collect(Collectors.toList());
    }

    @Test
    public void test_티켓목록_복사본_불일치() {
        LotteryMachine machine = new LotteryMachine();
        List<LotteryTicket> selectedTickets = createSelectedTickets(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(machine.buyLotteryTicket(Money.valueOf(2000), selectedTickets))
                .isNotSameAs(selectedTickets);
    }

    @Test
    public void test_돈을_제시했을때_얼마나_구매할_수_있는지() {
        Money money = Money.valueOf(14000);

        assertThat(LotteryMachine.howManyCanBuy(money))
                .isEqualTo(TicketCount.valueOf(14));
    }

    @Test
    public void test_갯수를_제시했을때_가격이_얼마나_되는지() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(LotteryMachine.howMuchIs(count))
                .isEqualTo(Money.valueOf(14000));

    }
}
