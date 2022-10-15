package controller;

import domain.Lotto;
import domain.LottoNumbers;
import domain.Statistic;
import domain.Money;
import service.LottoMachine;

import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {


        Money purchasedMoney = InputView.inputPurchaseMoney();
        LottoMachine lottoMachine = new LottoMachine();
        LottoNumbers createdRandomLottoNumbers = lottoMachine.purchaseLotto(purchasedMoney);
        ResultView.printRandomLotto(createdRandomLottoNumbers);

        Lotto winnerNumber = InputView.inputLastWeekWinnerNumber();

        Statistic statistic = new Statistic();
        statistic.findMatchLottoCount(winnerNumber, createdRandomLottoNumbers);
        ResultView.winnerStatistic(statistic, purchasedMoney);

    }


}
