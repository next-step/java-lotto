package step4.controller;

import step4.domain.*;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoController {

    private LottoController() { }

    public static void runLotto() {
        int lottoPurchaseMoney = InputView.purchaseLotto();

        int manualCount = InputView.purchaseManualCount();

        OutputView.purchaseManualLotto();

        int autoPayed = getAutoLottoPayed(lottoPurchaseMoney, manualCount);

        LottoFactory lottoFactory = new LottoFactory(
                new AutoLottoFactory(autoPayed, RandomLottoGenerator.of()), new ManualLottoFactory(getManualLottoList(manualCount)));

        OutputView.purchaseLotto(getAutoCount(autoPayed), manualCount);
        OutputView.printLottoTickets(lottoFactory.getLottoNumbersListToString());

        String lastWeekLotto = InputView.lastWeekLotto();
        LottoMatcher lottoMatcher = lottoFactory.matchNumbers(
                LottoGenerator.separateLottoToList(lastWeekLotto), new LottoNumber(InputView.initBonusBall()));

        OutputView.printStatics(lottoMatcher.getResult());

        OutputView.printInvestRate(lottoFactory.getLottoRatio(lottoMatcher, lottoPurchaseMoney));
    }

    private static int getAutoCount(int autoPayed) {
        return autoPayed / 1000;
    }

    private static int getAutoLottoPayed(int lottoPurchaseMoney, int manualCount) {
        return lottoPurchaseMoney - manualCount * 1000;
    }

    private static List<String> getManualLottoList(int manualCount) {
        List<String> lottoList = new ArrayList<>();
        IntStream.range(0, manualCount)
                .forEach(i -> lottoList.add(InputView.purchaseManualLotto()));
        return lottoList;
    }
}
