package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoShop {

    private static final LottoGenerator AUTO_LOTTO_GENERATOR = new AutoLottoGenerator();

    public LottoTickets buy(final long amount) {
        validateMinimumAmount(amount);

        long purchaseCount = getPurchaseCount(amount);
        return buyLottoTickets(purchaseCount);
    }

    private void validateMinimumAmount(final long amount) {
        if (amount < LottoTicket.PRIZE_AMOUNT) {
            throw new IllegalArgumentException("less then the minimum amount");
        }
    }

    private long getPurchaseCount(final long amount) {
        return Math.floorDiv(amount, LottoTicket.PRIZE_AMOUNT);
    }

    private LottoTickets buyLottoTickets(final long purchaseCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoTickets.add(AUTO_LOTTO_GENERATOR.generate());
        }
        return new LottoTickets(lottoTickets);
    }
}
