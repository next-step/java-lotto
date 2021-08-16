package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(InputView.readMoney());
        LottoSeller seller = new LottoSeller(new RandomLottoNumbersGenerator());
        Lottos lottos = seller.sell(money);
        OutputView.printLottos(lottos);

        Lotto winningLotto = new Lotto(new LottoNumbers(InputView.readNumbers()));
        LottoChecker lottoChecker = new LottoChecker(winningLotto);

        LottoResults lottoResults = new LottoResults();
        for (Lotto lotto : lottos) {
            lottoResults.add(lottoChecker.check(lotto));
        }

        LottoStatistics statistics = new LottoStatistics(lottoResults, money);
        OutputView.printStatistics(statistics);
    }
}
