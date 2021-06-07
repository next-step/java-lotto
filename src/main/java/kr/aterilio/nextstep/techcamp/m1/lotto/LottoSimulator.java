package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.lotto.view.InputView;
import kr.aterilio.nextstep.techcamp.m1.lotto.view.ResultView;

public class LottoSimulator {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {

        int money = inputView.inputMoney();
        LottoBundle lottoBundle = new LottoBundle(money);
        resultView.printBundle(lottoBundle);

        if (lottoBundle.empty()) {
            return;
        }

        String luckyNumber = inputView.inputLuckyNumber();
        LuckyNumbers luckyNumbers = new LuckyNumbers(luckyNumber);
        LottoResult lottoResult = new LottoResult(luckyNumbers, lottoBundle);
        resultView.printResult(lottoResult);

    }
}
