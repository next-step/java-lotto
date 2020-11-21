package step2.controller;

import step2.domain.Amount;
import step2.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketMaker {

    private static final int LOTTO_TOTAL_COUNT = 6;
    private static Amount amount;
    private int qty;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoTicketMaker(int lottoAmount) {
        amount = new Amount(lottoAmount);
        lottoCreateStart();
    }

    public static LottoTicketMaker of(int lottoAmount) {
        return new LottoTicketMaker(lottoAmount);
    }

    public int lottoPurchaseQty() {
        return amount.getLottoAmount() / 1000;
    }

    private void lottoCreateStart() {
        this.qty = lottoPurchaseQty();
        int bound = this.qty;
        IntStream.range(0, bound)
                .mapToObj(i -> lottoTicketCreate())
                .forEach(this.lottos::add);
    }

    public Lotto lottoTicketCreate() {
        Lotto lotto = new Lotto();
        IntStream.range(0, LOTTO_TOTAL_COUNT)
                .forEach(j -> lotto.lottoSort());
        return lotto;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

}
