package step3.controller;

import step3.domain.LastWeekLotto;
import step3.domain.LottoFactory;
import step3.domain.LottoMatcher;
import step3.domain.RandomLottoGenerator;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

    private LottoController() {}

    public static void runLotto() {
        int lottoPurchaseMoney = InputView.purchaseLotto();

        LottoFactory lottoFactory = new LottoFactory(lottoPurchaseMoney , RandomLottoGenerator.of());

        OutputView.purchaseLotto(lottoFactory.getLottoCount());
        OutputView.printLottoTickets(lottoFactory.getLottoNumbersListToString());

        LottoMatcher lottoMatcher = lottoFactory.matchNumbers(LastWeekLotto.separateLottoToList(InputView.lastWeekLotto()));

        OutputView.printStatics(lottoMatcher.getResult());

        OutputView.printInvestRate(lottoFactory.getLottoRatio(lottoMatcher, lottoPurchaseMoney));
    }
}
