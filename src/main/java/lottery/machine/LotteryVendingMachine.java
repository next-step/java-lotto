package lottery.machine;

import lottery.domain.*;
import lottery.supplier.BoundedUniqueRandomNumbersGenerator;
import lottery.supplier.NumbersGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryVendingMachine {

    public static final Money TICKET_PRICE = Money.valueOf(1000);

    private final NumbersGenerator numbersGenerator;

    public LotteryVendingMachine(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public List<LotteryTicket> buyLotteryTicket(Money price) {
        return buyLotteryTicket(price, Collections.EMPTY_LIST);
    }

    public List<LotteryTicket> buyLotteryTicket(Money price, List<LotteryTicket> selectedTickets) {
        TicketCount selectedTicketCount = TicketCount.valueOf(selectedTickets.size());
        TicketCount randomTicketCount = howManyCanBuy(price).subtract(selectedTicketCount);

        List<LotteryTicket> result = new ArrayList<>(selectedTickets);
        result.addAll(IntStream.range(0, randomTicketCount.getAmount())
                .mapToObj(i -> new LotteryTicket(numbersGenerator.nextNumbers(LotteryTicket.NUMBERS_COUNT)))
                .collect(Collectors.toList()));

        return result;
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
