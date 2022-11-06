package lotto.controller;

import lotto.domain.*;
import lotto.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static void run() {
        Lottos lottos = new Lottos(InputView.inputAmount(), InputView.inputManualLottoQuantity());

        List<Lotto> manualLottos = InputView.inputManualLottoNumbers(lottos.manualLottoQuantity());
        lottos.saveLotto(manualLottos);

        List<Lotto> autoLottos = createAutoLottos(lottos.autoLottoQuantity());
        lottos.saveLotto(autoLottos);

        OutputView.outputLottos(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputNumbers(), InputView.inputBonusNumber());
        RankCount rankCount = new RankCount();

        for (Lotto lotto : lottos.getLottos()) {
            rankCount.countRank(lotto, winningNumbers);
        }

        double result = Calculator.calculate(lottos, rankCount);
        OutputView.outputResult(new GameResult(rankCount, result));

    }

    private static List<Lotto> createAutoLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }

        return lottos;
    }
}
