package lottery.machine;

import lottery.domain.*;
import lottery.supplier.BoundedUniqueRandomNumbersGenerator;
import lottery.supplier.NumbersGenerator;
import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lottery.domain.LotteryNumber.LOWER_BOUND_INCLUSIVE;
import static lottery.domain.LotteryNumber.UPPER_BOUND_INCLUSIVE;
import static org.assertj.core.api.Assertions.assertThat;

public class LotteryVendingMachineTest {

    NumbersGenerator numbersGenerator =
            new BoundedUniqueRandomNumbersGenerator(LOWER_BOUND_INCLUSIVE, UPPER_BOUND_INCLUSIVE);

    @Test
    public void test_로또_구매_only_랜덤번호() {
        LotteryVendingMachine machine = new LotteryVendingMachine(numbersGenerator);
        Money price = Money.valueOf(14000);

        assertThat(machine.buyLotteryTicket(price))
                .hasSize(14);
    }

    @Test
    public void test_로또_구매_only_지정번호() {
        LotteryVendingMachine machine = new LotteryVendingMachine(numbersGenerator);
        List<LotteryTicket> selectedTickets = createSelectedTickets("1, 2, 3, 4, 5, 6",
                "7, 8, 9, 10, 11, 12");

        Money price = Money.valueOf(2000);

        assertThat(machine.buyLotteryTicket(price, selectedTickets))
                .hasSize(2)
                .containsAll(selectedTickets);
    }

    @Test
    public void test_로또_구매_지정번호_with_랜덤번호() {
        LotteryVendingMachine machine = new LotteryVendingMachine(numbersGenerator);
        List<LotteryTicket> selectedTickets = createSelectedTickets( "1, 2, 3, 4, 5, 6",
                "7, 8, 9, 10, 11, 12");

        Money price = Money.valueOf(14000);
        assertThat(machine.buyLotteryTicket(price, selectedTickets))
            .hasSize(14)
            .containsAll(selectedTickets);
    }

    private List<LotteryTicket> createSelectedTickets(String ...numbers) {
        return Arrays.asList(numbers)
                .stream()
                .map(LotteryTicket::generate)
                .collect(Collectors.toList());
    }

    @Test
    public void test_돈을_제시했을때_얼마나_구매할_수_있는지() {
        Money money = Money.valueOf(14000);

        assertThat(LotteryVendingMachine.howManyCanBuy(money))
                .isEqualTo(TicketCount.valueOf(14));
    }

    @Test
    public void test_갯수를_제시했을때_가격이_얼마나_되는지() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(LotteryVendingMachine.howMuchIs(count))
                .isEqualTo(Money.valueOf(14000));

    }
}
