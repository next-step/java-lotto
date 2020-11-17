package step2.controller;

import step2.domain.LastWeekLotto;
import step2.domain.LottoFactory;
import step2.domain.LottoMatcher;
import step2.domain.RandomLottoGenerator;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {

    private LottoController() {}

    public static void runLotto() {
        int lottoPurchaseMoney = InputView.purchaseLotto();

        LottoFactory lottoFactory = new LottoFactory(lottoPurchaseMoney ,RandomLottoGenerator.of());

        OutputView.purchaseLotto(lottoFactory.getLottoCount());
        OutputView.printLottoTickets(lottoFactory.getLottoNumbersListToString());

        LottoMatcher lottoMatcher = lottoFactory.matchNumbers(LastWeekLotto.separateLottoToList(InputView.lastWeekLotto()));

        OutputView.printStatics(lottoMatcher.getResult());

        OutputView.printInvestRate(lottoFactory.getLottoRatio(lottoMatcher, lottoPurchaseMoney));
    }
}
