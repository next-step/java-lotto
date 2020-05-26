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
    private final int lotteryTicketCounts;

    public LotteryMachine(PurchasePrice purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.lotteryTicketCounts = (int)(purchasePrice.getPurchasePrice() / LOTTERY_TICKET_PRICE);
    }

    public LotteryTicketsGroup getLotteryTicketsGroup() {
        return new LotteryTicketsGroup(
                Stream.generate(this::makeLotteryTicket)
                .limit(lotteryTicketCounts)
                .collect(Collectors.toList()) //Ticket n장 list를 LotteryTicketGroup으로 바인딩
        );
    }

    private LotteryTicket makeLotteryTicket() {
        List<Integer> lotteryNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Collections.shuffle(LOTTERY_NUMBERS_LIST);
            int pickedLotteryNumber = LOTTERY_NUMBERS_LIST.get(0);

            if (lotteryNumbers.contains(pickedLotteryNumber)) {
                i--;
            }
            else {
                lotteryNumbers.add(pickedLotteryNumber);
            }
        }
        return new LotteryTicket(lotteryNumbers.stream()
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
