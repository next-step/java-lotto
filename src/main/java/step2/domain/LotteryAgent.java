package step2.domain;

public class LotteryAgent {
    public static final Money PRICE_LOTTERY = Money.of(1000);

    public ExchangeResult exchange(Money money) {
        if (money.lessThan(PRICE_LOTTERY)) {
            throw new NotEnoughMoneyException();
        }

        Playslip playslip = new Playslip();
        int ticketCount = money.divide(PRICE_LOTTERY);

        return new ExchangeResult(new LotteryTickets(playslip.selectNumbers(ticketCount)),
                money.subtract(PRICE_LOTTERY.multiply(ticketCount)));
    }

    public static class ExchangeResult {
        private final LotteryTickets lotteryTickets;
        private final Money change;

        public ExchangeResult(LotteryTickets lotteryTickets, Money change) {
            this.lotteryTickets = lotteryTickets;
            this.change = change;
        }

        public LotteryTickets getLotteryTickets() {
            return lotteryTickets;
        }

        public Money getChange() {
            return change;
        }
    }
}
