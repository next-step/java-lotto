package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoShop {

    private static final int LOTTO_PRIZE_PRICE = 1000;

    public LottoShop() {
    }

    public LottoTickets buy(final long price, final LottoGenerator lottoGenerator) {
        long purchaseCount = getPurchaseCount(price);
        return buyLottoBatch(purchaseCount, lottoGenerator);
    }

    private long getPurchaseCount(final long price) {
        return Math.floorDiv(price, LOTTO_PRIZE_PRICE);
    }

    private LottoTickets buyLottoBatch(final long purchaseCount, final LottoGenerator lottoGenerator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoTickets.add(lottoGenerator.generate());
        }
        return new LottoTickets(lottoTickets);
    }
}
