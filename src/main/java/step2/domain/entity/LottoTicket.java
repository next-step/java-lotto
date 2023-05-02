package step2.domain.entity;

import step2.domain.vo.LottoPrize;

public class LottoTicket {

    private final Lotto lotto;
    private LottoPrize lottoPrize;

    public LottoTicket(Lotto lotto) {
        this(lotto, null);
    }

    public LottoTicket(Lotto lotto, LottoPrize lottoPrize) {
        this.lotto = lotto;
        this.lottoPrize = lottoPrize;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoPrize getLottoPrize() {
        return lottoPrize;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    public void changeLottoPrizeStatus(LottoPrize lottoPrize) {
        this.lottoPrize = lottoPrize;
    }
}
