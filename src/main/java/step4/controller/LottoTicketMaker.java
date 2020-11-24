package step4.controller;

import step4.domain.Amount;
import step4.domain.Lotto;
import step4.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMaker {
    private static final int LOTTO_TOTAL_COUNT = 6;

    private int qty;

    private Amount amount;

    private Lottos lottoTicket;

    public LottoTicketMaker(int lottoAmount) {
        amount = Amount.of(lottoAmount);
        this.qty = lottoPurchaseQty();
        lottoCreateStart();
    }

    public static LottoTicketMaker of(int lottoAmount) {
        return new LottoTicketMaker(lottoAmount);
    }

    public int lottoPurchaseQty() {
        return amount.lottoPurchaseQty();
    }

    private void lottoCreateStart() {
        List<Lotto> lotto = IntStream.range(0, this.qty)
                .mapToObj(i -> lottoTicketCreate())
                .collect(Collectors.toList());
        this.lottoTicket = new Lottos(lotto);
    }

    private Lotto lottoTicketCreate() {
        Lotto lotto = null;
        for (int j = 0; j < LOTTO_TOTAL_COUNT; j++) {
            lotto = new Lotto();
        }
        return lotto;
    }

    public Lottos getLottoTicket() {
        return this.lottoTicket;
    }
}
