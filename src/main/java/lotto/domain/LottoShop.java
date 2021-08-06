package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private final int lottoPrizePrice;

    public LottoShop(final int lottoPrizePrice) {
        this.lottoPrizePrice = lottoPrizePrice;
    }

    public LottoTickets buy(final long price, final LottoGenerator lottoGenerator) {
        long purchaseCount = getPurchaseCount(price);
        return buyLottoBatch(purchaseCount, lottoGenerator);
    }

    private long getPurchaseCount(final long price) {
        return Math.floorDiv(price, lottoPrizePrice);
    }

    private LottoTickets buyLottoBatch(final long purchaseCount, final LottoGenerator lottoGenerator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoTickets.add(lottoGenerator.generate());
        }
        return new LottoTickets(lottoTickets);
    }
}
