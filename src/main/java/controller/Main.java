package controller;

import domain.BonusNumber;
import domain.Lotto;
import domain.LottoResult;
import domain.Lottos;
import domain.Money;
import service.LottoGenerator;
import service.LottoMachine;
import service.RandomLottoGenerator;
import view.InputView;
import view.ResultView;

public class Main {


    public static void main(String[] args) {

        Money purchasedMoney = InputView.inputPurchaseMoney();
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoGenerator);
        Lottos createdRandomLottos = lottoMachine.purchaseLotto(purchasedMoney);
        ResultView.printRandomLotto(createdRandomLottos);

        Lotto winnerNumber = InputView.inputLastWeekWinnerNumber();

        BonusNumber bonusNumber = InputView.inputBonusNumber();

        LottoResult lottoResult = new LottoResult();
        lottoResult.findMatchLottoCount(winnerNumber, createdRandomLottos);
        ResultView.winnerStatistic(lottoResult, purchasedMoney);

    }
}
