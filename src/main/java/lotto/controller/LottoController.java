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

    public List<Lotto> create() {
        String input = view.inputMoney();

        List<Lotto> lottos = lottoService.create(input);

        return view.outputLottos(lottos);
    }

    public void winning(final List<Lotto> lottos) {
        String winningNumber = view.inputWinningNumber();

        WinningResult winningResult = lottoService.match(lottos, winningNumber);

        view.outputWinningResult(winningResult);
    }
}
