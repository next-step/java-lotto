package lottery.machine;

import lottery.domain.LotteryRank;
import lottery.domain.LotteryWinningStatistics;
import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {

    @Test
    public void test_로또_구매_랜덤번호() {
        LotteryMachine machine = new LotteryMachine();

        assertThat(machine.buyLotteryTicket(14000)).isEqualTo(14);
    }

    @Test
    public void test_로또_구매_지정번호() {
        LotteryMachine machine = new LotteryMachine(size -> Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(machine.buyLotteryTicket(14000)).isEqualTo(14);
    }

    @Test
    public void test_로또_구매_지정번호_당첨_1등_2개() {
        Supplier<List<Integer>> winningNumbersSupplier = () -> Arrays.asList(1, 2, 3, 4, 5, 6);
        LotteryMachine machine = new LotteryMachine(size -> winningNumbersSupplier.get());

        final List<Integer> winningNumbers = winningNumbersSupplier.get();
        machine.buyLotteryTicket(2000);

        final LotteryWinningStatistics statistics = machine.checkWinningNumbers(winningNumbers);
        assertThat(statistics.countRank(LotteryRank.FIRST))
                .isEqualTo(2);
    }
}
