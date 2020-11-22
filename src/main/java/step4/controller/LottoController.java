package step4.controller;

import step4.domain.*;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
        LottoMatcher lottoMatcher = lottoFactory.matchNumbers(LottoGenerator.separateLottoToList(lastWeekLotto), new LottoNumber(bonusBall));

        OutputView.printStatics(lottoMatcher.getResult());

        OutputView.printInvestRate(lottoFactory.getLottoRatio(lottoMatcher, lottoPurchaseMoney));
    }

    public static void runLotto2() {
        int lottoPurchaseMoney = InputView.purchaseLotto();

        int manualCount = InputView.purchaseManualCount();
        List<String> strLottoList = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            strLottoList.add(InputView.purchaseManualLott());
        }
        ManualLottoFactory manualLottoFactory = new ManualLottoFactory(strLottoList);

        int autoPay = lottoPurchaseMoney - manualCount * 1000;
        AutoLottoFactory autoLottoFactory = new AutoLottoFactory(autoPay, RandomLottoGenerator.of());

        LottoFactory lottoFactory = new LottoFactory(autoLottoFactory, manualLottoFactory);

        OutputView.purchaseLotto2(autoPay/1000 , manualCount);
        OutputView.printLottoTickets(lottoFactory.getLottoNumbersListToString());

        String lastWeekLotto = InputView.lastWeekLotto();
        int bonusBall = InputView.initBonusBall();
        LottoMatcher lottoMatcher = lottoFactory.matchNumbers(LottoGenerator.separateLottoToList(lastWeekLotto), new LottoNumber(bonusBall));

        OutputView.printStatics(lottoMatcher.getResult());

        OutputView.printInvestRate(lottoFactory.getLottoRatio(lottoMatcher, lottoPurchaseMoney));
    }
}
