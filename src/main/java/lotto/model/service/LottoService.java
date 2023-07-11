package lotto.model.service;

import lotto.model.domain.LottoMoney;
import lotto.model.domain.Lottos;
import lotto.model.domain.NumbersGenerator;

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

    public int getChange() {
        return this.lottoMoney.getChange();
    }
}
