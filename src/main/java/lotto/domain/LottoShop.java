package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoShop {

    private static final int LOTTO_PRIZE_AMOUNT = 1000;

    private final LottoGenerator lottoGenerator;

    public LottoShop(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoTickets buy(final long amount) {
        validationCheck(amount);

        long purchaseCount = getPurchaseCount(amount);
        return buyLottoBatch(purchaseCount);
    }

    private void validationCheck(final long amount) {
        if (amount < LOTTO_PRIZE_AMOUNT) {
            throw new IllegalArgumentException("less then the minimum amount");
        }

        if (amount % LOTTO_PRIZE_AMOUNT != 0 ) {
            throw new IllegalArgumentException("amount left over");
        }
    }

    private long getPurchaseCount(final long price) {
        return Math.floorDiv(price, LOTTO_PRIZE_AMOUNT);
    }

    private LottoTickets buyLottoBatch(final long purchaseCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoTickets.add(lottoGenerator.generate());
        }
        return new LottoTickets(lottoTickets);
    }
}
