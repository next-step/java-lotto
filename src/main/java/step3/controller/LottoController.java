package step3.controller;

import step3.domain.*;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

    private LottoController() {
    }

    public static void runLotto() {
        int lottoPurchaseMoney = InputView.purchaseLotto();

        LottoFactory lottoFactory = new LottoFactory(lottoPurchaseMoney, RandomLottoGenerator.of());

        OutputView.purchaseLotto(lottoFactory.getLottoCount());
        OutputView.printLottoTickets(lottoFactory.getLottoNumbersListToString());

        String lastWeekLotto = InputView.lastWeekLotto();
        int bonusBall = InputView.initBonusBall();
        LottoMatcher lottoMatcher = lottoFactory.matchNumbers(LastWeekLottoGenerator.separateLottoToList(lastWeekLotto), new LottoNumber(bonusBall));

        OutputView.printStatics(lottoMatcher.getResult());

        OutputView.printInvestRate(lottoFactory.getLottoRatio(lottoMatcher, lottoPurchaseMoney));
    }
}
