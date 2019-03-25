package lottery.machine;

import lottery.domain.*;
import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {

    @Test
    public void test_로또_구매_랜덤번호() {
        LotteryMachine machine = new LotteryMachine();
        Money price = new Money(14000);

        assertThat(machine.buyLotteryTicket(price))
                .isEqualTo(new TicketCount(price));
    }

    @Test
    public void test_로또_구매_지정번호() {
        LotteryMachine machine = new LotteryMachine(size -> Arrays.asList(1, 2, 3, 4, 5, 6));
        Money price = new Money(14000);

        assertThat(machine.buyLotteryTicket(price))
                .isEqualTo(new TicketCount(price));
    }

    @Test
    public void test_로또_구매_지정번호_당첨_1등_2개() {
        Supplier<List<Integer>> winningNumbersSupplier = () -> Arrays.asList(1, 2, 3, 4, 5, 6);
        LotteryMachine machine = new LotteryMachine(size -> winningNumbersSupplier.get());
        WinningTicket winningTicket = new WinningTicket(winningNumbersSupplier.get(), 10);

        machine.buyLotteryTicket(new Money(2000));
        LotteryWinningStatistics statistics = machine.raffle(winningTicket);

        assertThat(statistics.countRank(LotteryRank.FIRST))
                .isEqualTo(2);
    }

    @Test
    public void test_티켓목록_복사본_불일치() {
        LotteryMachine machine = new LotteryMachine();
        machine.buyLotteryTicket(new Money(1000));
        assertThat(machine.getTickets())
                .isNotSameAs(machine.getTickets());
    }
}
