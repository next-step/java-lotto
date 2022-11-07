package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoCustomer {

    private final Wallet wallet;
    private final List<LottoTicket> purchased;

    public LottoCustomer(final Money initialAmount) {
        this.wallet = new Wallet(initialAmount);
        this.purchased = new ArrayList<>();
    }

    public boolean canPurchase(final LottoTicket lottoTicket) {
        return wallet.hasAmount(lottoTicket.getFee());
    }

    public Money purchase(final LottoTicket lottoTicket) {
        if (!canPurchase(lottoTicket)) {
            return Money.ZERO;
        }
        wallet.minusAmount(lottoTicket.getFee());
        purchased.add(lottoTicket);
        return lottoTicket.getFee();
    }

    public List<LottoTicket> getPurchasedLottoTickets() {
        return Collections.unmodifiableList(purchased);
    }

    public List<LottoNumbers> getPurchasedLottoNumbers() {
        final List<LottoNumbers> result = purchased.stream()
            .map(LottoTicket::getLottoNumbers)
            .collect(Collectors.toList());
        return Collections.unmodifiableList(result);
    }

    public int getPurchasedCount() {
        return purchased.size();
    }

    public int getPurchasableCount(final Money fee) {
        return wallet.getPurchasableCount(fee);
    }
}
