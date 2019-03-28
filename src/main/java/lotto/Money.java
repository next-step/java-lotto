package lotto;

import java.util.Map;

public class Money {

    private final int amount;
    private final int manualTicketCount;

    private static final int TICKET_PRICE = 1_000;

    public Money(int amount, int manualTicketCount) {
        if (validAmount(amount)) {
            throw new IllegalArgumentException("구입 금액은 1_000 단위 입니다.");
        }
        this.amount = amount;
        if (validManualTicketCount(manualTicketCount)) {
            throw new IllegalArgumentException("수동구입 개수는 구입금액보다 많을 수 없습니다.");
        }
        this.manualTicketCount = manualTicketCount;

    }

    private boolean validAmount(int amount) {
        return (amount % TICKET_PRICE) != 0;
    }

    private boolean validManualTicketCount(int manualTicketCount) {
        return (amount / TICKET_PRICE) < manualTicketCount;
    }

    public int getTotalTicketCount() {
        return amount / TICKET_PRICE;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public int getBuyAutoTicketsCount() {
        return (this.amount - manualTicketCount) / TICKET_PRICE;
    }


    public int getTotalPrize(Map<LottoRank, Integer> lotteryResults) {
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            int money = totalPrizeCalculator(rank, lotteryResults.get(rank));
            totalPrize += money;
        }
        return totalPrize;
    }

    private int totalPrizeCalculator(LottoRank rank, Integer integer) {
        return rank.getWinningMoney() * integer;
    }

    public double getProfit(LotteryResults lotteryResults) {
        Map<LottoRank, Integer> lottoResults = lotteryResults.getLottoResults();
        int totalPrice = getTotalPrize(lottoResults);
        return totalPrice / (double) amount;
    }


}
