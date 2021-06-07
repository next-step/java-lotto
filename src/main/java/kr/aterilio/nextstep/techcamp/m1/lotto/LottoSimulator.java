package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.lotto.view.InputView;
import kr.aterilio.nextstep.techcamp.m1.lotto.view.ResultView;

public class LottoSimulator {

    private static final String MSG_ERR_LESS_MONEY = "로또를 구매하기 위한 충분한 금액이 필요합니다.(" + Lotto.MSG_PRICE_TAG + ")";

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {

        int money = inputView.inputMoney();
        LottoBundle lottoBundle = new LottoBundle(money);

        if (lottoBundle.empty()) {
            throw new IllegalArgumentException(MSG_ERR_LESS_MONEY);
        }
        resultView.printBundle(lottoBundle);

        String luckyNumber = inputView.inputLuckyNumber();
        LuckyNumbers luckyNumbers = new LuckyNumbers(luckyNumber);
        LottoResult lottoResult = new LottoResult(luckyNumbers, lottoBundle);
        resultView.printResult(lottoResult);

    }
}
