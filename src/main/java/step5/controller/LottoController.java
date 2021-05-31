package step5.controller;


import step5.domain.*;
import step5.ui.InputView;
import step5.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class LottoController {
    public static void main(String[] args) {

        List<Lotto> manualLotto = new ArrayList<>();
        List<Lotto> autoLotto = new ArrayList<>();
        List<Lotto> totalLotto = new ArrayList<>();

        int purchaseAmount = InputView.purchaseAmount();
        Money money = new Money(purchaseAmount);

        ManualNumber manualNumber = new ManualNumber(money, InputView.getManualNumber());

        InputView.showInputManualLotto();

        while (manualNumber.moreThanZero()) {
            manualLotto.add(new Lotto(InputView.getLottoManually()));
            manualNumber.minus();
        }

        while (money.canBuyAutoLotto()) {
            autoLotto.add(RandomLottoNumGenerator.createLottoNums());
            money.buyOneLotto();
        }

        ResultView.showAutoLotto(autoLotto);

        getTotalLotto(manualLotto, autoLotto, totalLotto);
        List<Integer> lotto = InputView.getLotto();
        int bonusNumber = InputView.getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        Ranks ranks = Ranks.of(totalLotto.stream().map(userLotto -> LottoGame.match(userLotto, winningLotto)).collect(toList()));

        ResultView.showStatistics(ranks);
        ResultView.showRate(ranks);

    }

    private static void getTotalLotto(List<Lotto> manualLotto, List<Lotto> autoLotto, List<Lotto> totalLotto) {
        totalLotto.addAll(manualLotto);
        totalLotto.addAll(autoLotto);
    }
}
