package controller;

import domain.LottoNumbers;
import domain.Money;
import service.LottoMachine;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {

        Money purchasedMoney = InputView.inputPurchaseMoney();

        LottoMachine lottoMachine = new LottoMachine();
        LottoNumbers lottoNumbers = lottoMachine.purchaseLotto(purchasedMoney);



        ResultView.printRandomLotto();

    }

}
