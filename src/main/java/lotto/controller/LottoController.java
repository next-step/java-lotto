package lotto.controller;

import lotto.domain.Lotto;
import lotto.dto.WinningResult;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;

public class LottoController {
    private final View view;
    private final LottoService lottoService;

    public LottoController(final View view, final LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }

    public void play() {
        winning(create());
    }

    private List<Lotto> create() {
        String inputMoney = view.inputMoney();

        List<Lotto> lottos = lottoService.create(inputMoney);

        view.outputLottos(lottos);
        return lottos;
    }

    private void winning(final List<Lotto> lottos) {
        String winningNumber = view.inputWinningNumber();

        WinningResult winningResult = lottoService.match(lottos, winningNumber);

        view.outputWinningResult(winningResult);
    }
}
