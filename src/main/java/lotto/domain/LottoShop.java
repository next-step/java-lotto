package lotto.domain;

public final class LottoShop {

    private static final LottoGenerator AUTO_LOTTO_GENERATOR = new AutoLottoGenerator();

    private final LottoTickets lottoTickets;

    public LottoShop() {
        this.lottoTickets = new LottoTickets();
    }

    public LottoShop(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets buy(final long amount) {
        validateMinimumAmount(amount);

        long purchaseCount = getPurchaseAutoLottoTicketCount(amount);
        buyAutoLottoTickets(purchaseCount);

        return lottoTickets;
    }

    private void validateMinimumAmount(final long amount) {
        if (amount < LottoTicket.PRIZE_AMOUNT) {
            throw new IllegalArgumentException("less then the minimum amount");
        }
    }

    private long getPurchaseAutoLottoTicketCount(final long amount) {
        long purchaseAutoLottoTicketAmount = amount - getPurchaseManualLotto();
        return Math.floorDiv(purchaseAutoLottoTicketAmount, LottoTicket.PRIZE_AMOUNT);
    }

    private int getPurchaseManualLotto() {
        return lottoTickets.size() * LottoTicket.PRIZE_AMOUNT;
    }

    private void buyAutoLottoTickets(final long purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            lottoTickets.add(AUTO_LOTTO_GENERATOR.generate());
        }
    }
}
