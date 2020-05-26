package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LotteryMachine {

    private static final long LOTTERY_TICKET_PRICE = 1000;
    private static final List<Integer> LOTTERY_NUMBERS_LIST = IntStream.rangeClosed(1, 45).boxed()
            .collect(Collectors.toList());
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 6;
    private final int lotteryTicketCounts;

    public LotteryMachine(PurchasePrice purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.lotteryTicketCounts = (int)(purchasePrice.getPurchasePrice() / LOTTERY_TICKET_PRICE);
    }

    public LotteryTicketsGroup makeLotteryTicketsGroup() {
        return new LotteryTicketsGroup(
                Stream.generate(this::makeLotteryTicket)
                .limit(lotteryTicketCounts)
                .collect(Collectors.toList())
        );
    }

    public LotteryTicketsGroup findWinnerTicketsGroup(LotteryTicketsGroup lotteryTicketsGroup,
                                                      LotteryTicket lastWinnerTicket) {
        return new LotteryTicketsGroup(lotteryTicketsGroup.findWinnerTicketsGroup(lastWinnerTicket));
    }

    private LotteryTicket makeLotteryTicket() {
        Collections.shuffle(LOTTERY_NUMBERS_LIST);
        List<Integer> pickedLotteryNumbers = LOTTERY_NUMBERS_LIST.subList(FIRST_INDEX, LAST_INDEX);
        Collections.sort(pickedLotteryNumbers);
        return new LotteryTicket(
                pickedLotteryNumbers.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList())
        );
    }

    private void validatePurchasePrice(PurchasePrice purchasePrice) {
        if (purchasePrice.getPurchasePrice() < LOTTERY_TICKET_PRICE)
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_NOT_ENOUGH);
    }

    public int getLotteryTicketCounts() {
        return lotteryTicketCounts;
    }
}
