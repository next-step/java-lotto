package lottery.machine;

import lottery.domain.*;
import lottery.supplier.BoundedUniqueRandomNumbersGenerator;
import lottery.supplier.NumbersGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryMachine {

    public static final Money TICKET_PRICE = Money.valueOf(1000);

    private final NumbersGenerator numbersGenerator;

    private List<LotteryTicket> lotteryTickets;

    public LotteryMachine() {
        this.numbersGenerator = new BoundedUniqueRandomNumbersGenerator(LotteryNumber.LOWER_BOUND_INCLUSIVE, LotteryNumber.UPPER_BOUND_INCLUSIVE);
    }

    public LotteryWinningStatistics raffle(WinningTicket winningTicket) {
        return new LotteryWinningStatistics(winningTicket, this.lotteryTickets);
    }

    public List<LotteryTicket> buyLotteryTicket(Money price) {
        return buyLotteryTicket(price, Collections.EMPTY_LIST);
    }

    public List<LotteryTicket> buyLotteryTicket(Money price, List<LotteryTicket> selectedTickets) {
        TicketCount selectedTicketCount = TicketCount.valueOf(selectedTickets.size());
        TicketCount randomTicketCount = howManyCanBuy(price).subtract(selectedTicketCount);

        this.lotteryTickets = new ArrayList<>(selectedTickets);
        this.lotteryTickets.addAll(IntStream.range(0, randomTicketCount.getAmount())
                .mapToObj(i -> new LotteryTicket(numbersGenerator.nextNumbers(LotteryTicket.NUMBERS_COUNT)))
                .collect(Collectors.toList()));

        return new ArrayList<>(this.lotteryTickets);
    }

    public static TicketCount howManyCanBuy(Money price) {
        int money = price.getAmount();
        return TicketCount.valueOf(money / TICKET_PRICE.getAmount());
    }

    public static Money howMuchIs(TicketCount amountWantedBuy) {
        int count = amountWantedBuy.getAmount();
        return Money.valueOf(count * TICKET_PRICE.getAmount());
    }
}
