package controller;

import domain.LottoResult;
import domain.Lottos;
import domain.WinningLotto;
import service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(final LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public Lottos generateAutoLottos(final long inputMoney) {
        return lottoService.generateAutoLottos(inputMoney);
    }

    public WinningLotto generateWinningLotto(final List<Integer> lottoNumbers, final int bonus) {
        return lottoService.generateWinningLotto(lottoNumbers, bonus);
    }

    public LottoResult result(final Lottos lottos, final WinningLotto winningLotto) {
        return lottoService.computeLottoResult(lottos, winningLotto);
    }
}
