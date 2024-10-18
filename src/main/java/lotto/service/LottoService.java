package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.InputNumber;
import lotto.vo.WinningResult;

import java.util.List;

public class LottoService {
    private final LottoGame lottoGame;

    public LottoService(final LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public List<Lotto> create(final String money) {
        return lottoGame.create(money);
    }

    public WinningResult match(final List<Lotto> lottos, final InputNumber inputNumber) {
        return lottoGame.match(lottos, inputNumber);
    }
}
