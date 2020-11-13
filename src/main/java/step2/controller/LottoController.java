package step2.controller;

import step2.domain.LastWeekLotto;
import step2.domain.LottoFactory;
import step2.domain.LottoMatcher;
import step2.domain.LottoRank;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.Map;

public class LottoController {

    private LottoController() {}

    public static void runLotto() {
        int lottoPurchaseMoney = InputView.purchaseLotto();

        LottoFactory lottoFactory = new LottoFactory(lottoPurchaseMoney);
        OutputView.purchaseLotto(lottoFactory.getLottoCount());
        OutputView.printLottoTickets(lottoFactory.getLottoNumbersListToString());

        LottoMatcher lottoMatcher = lottoFactory.matchNumbers(LastWeekLotto.separateLottoToList(InputView.lastWeekLotto()));

        Map<LottoRank, Integer> result = lottoMatcher.getResult();
        System.out.println(result.get(LottoRank.MISS));
        System.out.println(result.get(LottoRank.FORTH));
        System.out.println(result.get(LottoRank.THIRD));
        System.out.println(result.get(LottoRank.SECOND));
        System.out.println(result.get(LottoRank.FIRST));

    }
}
