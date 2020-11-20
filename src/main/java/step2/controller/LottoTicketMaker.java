package step2.controller;

import step2.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketMaker {

    private static final int LOTTO_TOTAL_COUNT = 6;
    private final int lottoAmount;
    private int qty;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoTicketMaker(int lottoAmount) {
        this.lottoAmount = lottoAmount;
        lottoCreateStart();
    }

    public static LottoTicketMaker of(int lottoAmount) {
        purchaseAmountValidate(lottoAmount);
        return new LottoTicketMaker(lottoAmount);
    }

    public int lottoPurchaseQty() {
        return this.lottoAmount / 1000;
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

    public static void purchaseAmountValidate(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("구입 금액 값이 없습니다.");
        }

        if (amount < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원부터 입력가능합니다.");
        }

        if (amount > 100000) {
            throw new IllegalArgumentException("로또는 10만원 이상 구매불가합니다.");
        }
    }
}
