package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Number;
import lotto.model.Result;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        int purchasedCount = InputView.acceptPuchaseAmount();
        List<Lotto> lottos = makeLottos(purchasedCount);
        ResultView.printLottos(lottos);
        String[] array = InputView.acceptWinningNumber();
        Number bonusNumber = InputView.acceptBonusNumber();

        Lottos purchasedLottos = new Lottos(lottos);
        Result result = purchasedLottos.makeResult(makeWinningNumber(array), bonusNumber);

        ResultView.printResult(purchasedCount * Lotto.eachAmount, result);
    }

    private List<Lotto> makeLottos(int purchasedCount) {
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < purchasedCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return lottos;
    }

    private Lotto makeWinningNumber(String[] array) {
        return new Lotto(Arrays.stream(array)
                               .map(Number::new)
                               .collect(Collectors.toList()));
    }
}
