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

        int money = InputView.inputPurchaseMoney();
        Money purchasedMoney = new Money(money);

        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        LottoIssueMachine lottoIssueMachine = new LottoIssueMachine(randomLottoGenerator);
        Lottos createdRandomLottos = lottoIssueMachine.purchaseLotto(purchasedMoney);
        ResultView.printRandomLotto(createdRandomLottos);

        String winnerInputValue = InputView.inputLastWeekWinnerNumber();
        Lotto winnerNumber = new Lotto(winnerInputValue);

        String bonusInputValue = InputView.inputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(bonusInputValue);

        LottoResult lottoResult = new LottoResult();
        lottoResult.findMatchLottoCount(winnerNumber, createdRandomLottos, bonusNumber);
        ResultView.winnerStatistic(lottoResult, purchasedMoney);

    }
}
