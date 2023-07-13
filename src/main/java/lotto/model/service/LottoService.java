package lotto.model.service;

import lotto.model.domain.LottoMoney;
import lotto.model.domain.LottoResult;
import lotto.model.domain.Lottos;
import lotto.model.domain.NumbersGenerator;
import lotto.model.domain.WinningNumbers;

public final class LottoService {

    private final Lottos lottos;
    private final LottoMoney lottoMoney;

    public LottoService(final LottoMoney lottoMoney, final NumbersGenerator numbersGenerator) {
        this.lottoMoney = lottoMoney;
        this.lottos = new Lottos(lottoMoney.getTotalCount(), numbersGenerator);
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
