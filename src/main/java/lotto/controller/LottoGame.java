package lotto.controller;

import lotto.domain.*;
import lotto.utils.StringUtils;
import lotto.views.InputView;
import lotto.views.ResultView;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoGame {

    public LottoGame() { }

    public void emptyValidation(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다.");
        }
    }

    public List<Lotto> generateLotto(Amount amount) {
        return LottoGenerator.generate(amount.quantity());
    }

    public Amount generateAmount(String value) {
        return new Amount(Integer.parseInt(value));
    }

    public LotteryMachine generateLotteryMachine(String value, Amount purchaseAmount) {
        return new LotteryMachine(value, purchaseAmount);
    }

    public void start() {
        String value = InputView.getInputAmount();
        emptyValidation(value);

        Amount purchaseAmount = generateAmount(value);

        List<Lotto> lottos = generateLotto(purchaseAmount);
        ResultView.showPurchaseLotto(lottos);

        value = InputView.getWinningNumbers();
        emptyValidation(value);

        LotteryMachine lotteryMachine = generateLotteryMachine(value, purchaseAmount);
        LottoResult lottoResult = lotteryMachine.result(lottos);

        ResultView.showWinningResult(lottoResult);
    }
}
