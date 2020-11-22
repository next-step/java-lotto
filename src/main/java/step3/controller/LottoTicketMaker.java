package step3.controller;

import step3.domain.Amount;
import step3.domain.Lotto;
import step3.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMaker {
    private static final int LOTTO_TOTAL_COUNT = 6;

    private int qty;

    private Amount amount;

    private Lottos lottoTicket;

    public LottoTicketMaker(int lottoAmount) {
        amount = new Amount(lottoAmount);
        this.qty = lottoPurchaseQty();
        lottoCreateStart();
    }

    public static LottoTicketMaker of(int lottoAmount) {
        return new LottoTicketMaker(lottoAmount);
    }

    public int lottoPurchaseQty() {
        return amount.getLottoAmount() / 1000;
    }

    private void lottoCreateStart() {
        List<Lotto> lottos;
        lottos = IntStream.range(0, this.qty)
                .mapToObj(i -> lottoTicketCreate())
                .collect(Collectors.toList());
        this.lottoTicket = new Lottos(lottos);
    }

    public Lotto lottoTicketCreate() {
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
