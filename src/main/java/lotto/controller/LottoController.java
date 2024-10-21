package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.InputNumber;
import lotto.vo.LottoCreateRequest;
import lotto.service.LottoService;
import lotto.vo.LottoCreateResponse;
import lotto.vo.WinningResult;
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
        LottoCreateRequest lottoCreateRequest = view.input();

        LottoCreateResponse lottos = lottoService.create(lottoCreateRequest);

        view.outputLottos(lottos);
        return lottos.getLottos();
    }

    private void winning(final List<Lotto> lottos) {
        InputNumber inputNumber = view.inputNumber();

        WinningResult winningResult = lottoService.match(lottos, inputNumber);

        view.outputWinningResult(winningResult);
    }
}
