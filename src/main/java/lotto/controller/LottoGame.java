package lotto.controller;

import lotto.domain.*;
import lotto.utils.StringUtils;
import lotto.views.InputView;
import lotto.views.ResultView;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame() {
        inputView = new InputView();
        resultView = new ResultView();
    }

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

    public LotteryMachine generateLotteryMachine(String value) {
        return new LotteryMachine(value);
    }

    public LinkedHashMap<Integer, Integer> generateGameResult(LotteryMachine lotteryMachine, List<Lotto> lottos) {
        return lotteryMachine.result(lottos);
    }

    public double yeildCalculate(Amount amount, LinkedHashMap<Integer, Integer> resultMap) {
        YieldCalculator yieldCalculator = new YieldCalculator(amount);
        yieldCalculator.proceedsCalculate(resultMap);
        return yieldCalculator.yield();
    }

    public void start() {
        String value = inputView.getInputAmount();
        emptyValidation(value);
        Amount amount = generateAmount(value);

        List<Lotto> lottos = generateLotto(amount);
        resultView.showPurchaseLotto(lottos);

        value = inputView.getWinningNumbers();
        emptyValidation(value);
        LotteryMachine lotteryMachine = generateLotteryMachine(value);

        LinkedHashMap<Integer, Integer> resultMap = generateGameResult(lotteryMachine, lottos);

        double yeild = yeildCalculate(amount, resultMap);
        resultView.showWinningResult(new LottoResultDto(yeild, resultMap));
    }
}
