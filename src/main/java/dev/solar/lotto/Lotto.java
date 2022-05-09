package dev.solar.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private int payment;
    private int purchaseAmount = 0;
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public static Lotto buyLottoTickets(final int payment) {
        final Lotto lotto = new Lotto();
        lotto.payment = payment;
        lotto.purchaseAmount = payment / LOTTO_PRICE;
        return lotto;
    }

    public LottoTicket pick() {
        if (!isRemainNewLottoTickes()) {
            throw new LottoException("모든 로또티켓을 사용했습니다.");
        }
        final LottoTicket lottoTicket = LottoTicket.buyOne();
        decreasePurchaseAmount();
        lottoTickets.add(lottoTicket);
        return lottoTicket;
    }

    public boolean isRemainNewLottoTickes() {
        return purchaseAmount > 0;
    }

    private void decreasePurchaseAmount() {
        this.purchaseAmount -= 1;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
