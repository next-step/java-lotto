package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(InputView.readMoney());
        ManualNumbers manualNumbers = new ManualNumbers(InputView.readManualNumbers());

        LottoSeller seller = new LottoSeller(new RandomLottoNumbersGenerator());
        Lottos lottos = seller.sell(money, manualNumbers);
        OutputView.printLottos(lottos, manualNumbers.size());

        Lotto winningLotto = new Lotto(new LottoNumbers(InputView.readLottoNumbers()));
        LottoNumber bonusNumber = new LottoNumber(InputView.readBonusNumber());
        LottoChecker lottoChecker = new LottoChecker(new WinningNumbers(winningLotto, bonusNumber));

        LottoResults lottoResults = new LottoResults();
        for (Lotto lotto : lottos) {
            lottoResults.add(lottoChecker.check(lotto));
        }

        LottoStatistics statistics = new LottoStatistics(lottoResults, money);
        OutputView.printStatistics(statistics);
    }
}
