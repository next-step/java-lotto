package lottery.domain;

import java.util.Map;

public class LotteryGameMachine {

    private static final long LOTTERY_TICKET_PRICE = 1000;
    private final int lotteryTicketCounts;

    public LotteryGameMachine(PurchasePrice purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.lotteryTicketCounts = (int) (purchasePrice.getPurchasePrice() / LOTTERY_TICKET_PRICE);
    }

/*    public LotteryTicketsGroup makeLotteryTicketsGroup() {
        return new LotteryTicketsGroup(
                Stream.generate(this::makeLotteryTicket)
                        .limit(lotteryTicketCounts)
                        .collect(Collectors.toList())
        );
    }*/

    public Map<LotteryRank, Integer> findWinnerTicketCountsByRankMap(LotteryTicketsGroup lotteryTicketsGroup,
                                                                     LotteryTicket lastWinnerTicket) {
        return lotteryTicketsGroup.findWinnerTicketCountsByRankMap(lastWinnerTicket);
    }

    /*private LotteryTicket makeLotteryTicket() {
        Collections.shuffle(LOTTERY_NUMBERS_LIST);
        List<Integer> pickedLotteryNumbers = LOTTERY_NUMBERS_LIST.subList(FIRST_INDEX, LAST_INDEX);
        Collections.sort(pickedLotteryNumbers);
        return new LotteryTicket(
                pickedLotteryNumbers.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList())
        );
    }*/

    private void validatePurchasePrice(PurchasePrice purchasePrice) {
        if (purchasePrice.getPurchasePrice() < LOTTERY_TICKET_PRICE)
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_NOT_ENOUGH);
    }

    public int getLotteryTicketCounts() {
        return lotteryTicketCounts;
    }
}
