package controller;

import domain.BonusNumber;
import domain.Lotto;
import domain.LottoResult;
import domain.Lottos;
import domain.Money;
import service.LottoIssueMachine;
import service.RandomLottoGenerator;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {

        Money purchasedMoney = InputView.inputPurchaseMoney();
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        LottoIssueMachine lottoIssueMachine = new LottoIssueMachine(randomLottoGenerator);
        Lottos createdRandomLottos = lottoIssueMachine.purchaseLotto(purchasedMoney);
        ResultView.printRandomLotto(createdRandomLottos);

        Lotto winnerNumber = InputView.inputLastWeekWinnerNumber();

        BonusNumber bonusNumber = InputView.inputBonusNumber();

        LottoResult lottoResult = new LottoResult();
        lottoResult.findMatchLottoCount(winnerNumber, createdRandomLottos, bonusNumber);
        ResultView.winnerStatistic(lottoResult, purchasedMoney);

    }
}
