package step3.controller;

import static step3.view.InputView.readBonusNumberNotContains;
import static step3.view.InputView.readLotto;
import static step3.view.InputView.readMoney;

import step3.model.Lotto;
import step3.model.LottoBundle;
import step3.model.LottoMachine;
import step3.model.LottoNumber;
import step3.model.LottoPrize;
import step3.model.Money;
import step3.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = readMoney();
        LottoBundle lottoBundle = LottoMachine.purchaseLotto(money);
        OutputView.printLottoBundle(lottoBundle);

        Lotto winner = readLotto();
        LottoNumber bonusNumber = readBonusNumberNotContains(winner);
        LottoPrize lottoPrize = lottoBundle.totalReward(winner, bonusNumber);
        OutputView.printLottoPrize(lottoPrize);
    }
}
