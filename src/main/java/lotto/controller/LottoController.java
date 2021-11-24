package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Result;
import lotto.service.LottoService;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        int purchasedCount = InputView.acceptPuchaseAmount();
        List<Lotto> lottos = makeLottos(purchasedCount);
        ResultView.printLottos(lottos);
        String[] array = InputView.acceptWinningNumber();

        Result result = lottoService.checkLotto(lottos, makeWinningNumber(array));

        ResultView.printResult(purchasedCount * Lotto.eachAmount, result);
    }

    private List<Lotto> makeLottos(int purchasedCount) {
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < purchasedCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return lottos;
    }

    private List<Number> makeWinningNumber(String[] array) {
        return Arrays.stream(array)
                     .map(Number::new)
                     .collect(Collectors.toList());
    }
}
