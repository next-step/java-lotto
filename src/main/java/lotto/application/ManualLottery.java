package lotto.application;

import lotto.domain.lotto.Lottery;
import lotto.domain.machine.LottoMoney;

public class ManualLottery {
    private final Lottery lottery;
    private final LottoMoney lottoMoney;

    public ManualLottery(Lottery lottery, LottoMoney lottoMoney) {
        this.lottery = lottery;
        this.lottoMoney = lottoMoney;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public LottoMoney getLottoMoney() {
        return lottoMoney;
    }
}
