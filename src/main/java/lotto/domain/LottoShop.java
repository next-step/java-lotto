package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoShop {

    private static final int LOTTO_PRIZE_PRICE = 1000;

    private final LottoGenerator lottoGenerator;

    public LottoShop(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoTickets buy(final long price) {
        long purchaseCount = getPurchaseCount(price);
        return buyLottoBatch(purchaseCount);
    }

    private long getPurchaseCount(final long price) {
        return Math.floorDiv(price, LOTTO_PRIZE_PRICE);
    }

    private LottoTickets buyLottoBatch(final long purchaseCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoTickets.add(lottoGenerator.generate());
        }
        return new LottoTickets(lottoTickets);
    }
}
