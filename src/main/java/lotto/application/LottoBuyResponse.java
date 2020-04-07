package lotto.application;

import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.Lotto;

public class LottoBuyResponse {
    private final Lottery lotteryByManual;
    private final Lottery lotteryByAuto;

    public LottoBuyResponse(Lottery lotteryByManual, Lottery lotteryByAuto) {
        this.lotteryByManual = lotteryByManual;
        this.lotteryByAuto = lotteryByAuto;
    }

    public Lottery getLotteryByManual() {
        return lotteryByManual;
    }

    public Lottery getLotteryByAuto() {
        return lotteryByAuto;
    }

    public Lottery getLotteryTotal() {
        return new Lottery(lotteryByManual, lotteryByAuto);
    }
}
