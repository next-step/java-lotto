package lotto.model;

public class Automatic {
    private final LottoMoney autoLottoMoney;

    public Automatic(final LottoMoney lottoMoney) {
        this.autoLottoMoney = lottoMoney;
    }

    public int getAutoCount() {
        return autoLottoMoney.getLottoCount();
    }
}
