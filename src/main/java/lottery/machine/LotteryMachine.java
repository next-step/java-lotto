package lottery.machine;

import lottery.domain.*;
import lottery.supplier.BoundedUniqueNumbersGenerator;
import lottery.supplier.NumbersGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryMachine {

    private final NumbersGenerator numbersGenerator;

    private List<LotteryTicket> lotteryTickets;

    public LotteryMachine() {
        this(new BoundedUniqueNumbersGenerator(LotteryNumber.LOWER_BOUND_INCLUSIVE, LotteryNumber.UPPER_BOUND_INCLUSIVE));
    }

    public LotteryMachine(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public TicketCount buyLotteryTicket(Money price) {
        final TicketCount ticketCount = new TicketCount(price);

        this.lotteryTickets = IntStream.range(0, ticketCount.count)
                .mapToObj(i -> new LotteryTicket(numbersGenerator.nextNumbers(LotteryTicket.NUMBERS_COUNT)))
                .collect(Collectors.toList());

        return ticketCount;
    }

    public List<LotteryTicket> getTickets() {
        return new ArrayList<>(this.lotteryTickets);
    }

    public LotteryWinningStatistics raffle(WinningTicket winningTicket) {
        return new LotteryWinningStatistics(winningTicket, this.lotteryTickets);
    }
}
