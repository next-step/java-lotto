package step2.controller;

import step2.domain.Lotto;
import step2.util.LottoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoController {

    private static final int LOTTO_TOTAL_COUNT = 6;
    private final int lottoAmount;
    private int qty;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoController(int lottoAmount) {
        this.lottoAmount = lottoAmount;
        lottoCreateStart();
    }

    public static LottoController of(int lottoAmount) {
        LottoUtil.purchaseAmountValidate(lottoAmount);
        return new LottoController(lottoAmount);
    }

    public int lottoPurchaseQty() {
        return this.lottoAmount / 1000;
    }

    private void lottoCreateStart() {
        this.qty = lottoPurchaseQty();
        IntStream.range(0, this.qty)
                .mapToObj(i -> lottoTicketCreate())
                .forEach(this.lottos::add);
    }

    public Lotto lottoTicketCreate() {
        Lotto lotto = new Lotto();
        IntStream.range(0, LOTTO_TOTAL_COUNT)
                .forEach(j -> lotto.addNumber());
        return lotto;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public double getTotalYield(double winningAmount) {
        double totalYield = winningAmount / this.lottoAmount;
        return Double.parseDouble(String.format("%.2f", totalYield));
    }
}
