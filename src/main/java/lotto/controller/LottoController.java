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

        createLottos(lottos);
        OutputView.outputLottos(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputNumbers(), InputView.inputBonusNumber());
        RankCount rankCount = new RankCount();
        lottos.countRank(rankCount, winningNumbers);

        double result = Calculator.calculate(lottos, rankCount);
        OutputView.outputResult(new GameResult(rankCount, result));
    }

    private static void createLottos(Lottos lottos) {
        List<Lotto> manualLottos = InputView.inputManualLottoNumbers(lottos.manualLottoQuantity());
        lottos.saveLotto(manualLottos);

        List<Lotto> autoLottos = createAutoLottos(lottos.autoLottoQuantity());
        lottos.saveLotto(autoLottos);
    }

    private static List<Lotto> createAutoLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }

        return lottos;
    }
}
