package lotto.model.service;

import lotto.model.domain.*;

public final class LottoService {

    private final Lottos lottos;
    private final LottoMoney lottoMoney;

    public LottoService(final int money, final NumbersGenerator numbersGenerator) {
        this.lottoMoney = new LottoMoney(money);
        this.lottos = new Lottos(lottoMoney.getCount(), numbersGenerator);
    }

    public Lottos getLottos() {
        return this.lottos;
    }

    public LottoMoney getLottoMoney() {
        return this.lottoMoney;
    }

    public int getChange() {
        return this.lottoMoney.getChange();
    }

    public LottoResult calculateLottoResult(final WinningNumbers winningNumbers) {
        return new LottoResult(lottos.matchWinningNumbers(winningNumbers), lottoMoney);
    }
}
