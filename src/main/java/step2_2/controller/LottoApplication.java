package step2_2.controller;

import static step2_2.view.InputView.readLotto;
import static step2_2.view.InputView.readMoney;
import static step2_2.view.OutputView.printLottoBundle;
import static step2_2.view.OutputView.printLottoResult;

import step2_2.domain.Lotto;
import step2_2.domain.LottoBundle;
import step2_2.domain.LottoResult;
import step2_2.domain.Money;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = readMoney();
        LottoBundle lottoBundle = new LottoBundle(money);
        printLottoBundle(lottoBundle);

        Lotto winner = readLotto();
        LottoResult lottoResult = lottoBundle.getLottoResult(winner);
        printLottoResult(lottoResult);
    }
}
