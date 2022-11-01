package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domains.Lotto;
import lotto.domains.LottoGenerator;
import lotto.domains.LottoPurchasedAmount;
import lotto.domains.LottoStatistics;
import lotto.domains.LottoWinner;
import lotto.domains.UnsignedInteger;
import lotto.views.InputView;
import lotto.views.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void run() {
        InputView inputView = InputView.INSTANCE;

        LottoPurchasedAmount money = LottoPurchasedAmount.of(inputView.inputPurchaseMoney());
        UnsignedInteger manualLottoCount = UnsignedInteger.parse(
                inputView.inputPurchaseCountByManual());
        money = money.spend(manualLottoCount);

        List<Lotto> manualLottoList = prepareManualLottoList(inputView, manualLottoCount);
        List<Lotto> autoLottoList = LottoGenerator.INSTANCE.purchaseByAuto(money);
        ResultView.INSTANCE.printPurchasedLottoList(manualLottoList, autoLottoList);

        playGame(inputView, manualLottoList);
    }

    private static void playGame(InputView inputView, List<Lotto> manualLottoList) {
        LottoWinner winner = LottoGenerator.INSTANCE.createLottoWinner(
                inputView.inputLastWinner(),
                inputView.inputBonusNumber()
        );
        ResultView.INSTANCE.printStatistics(new LottoStatistics(manualLottoList, winner));
    }

    private static List<Lotto> prepareManualLottoList(InputView inputView, UnsignedInteger manualLottoCount) {
        if (manualLottoCount.isZero()) {
            return Collections.emptyList();
        }

        inputView.printManualLottoTitle();
        List<Lotto> lottoList = IntStream.range(0, manualLottoCount.getValue())
                .boxed()
                .map(i -> LottoGenerator.INSTANCE.purchaseByManual(inputView.inputLottoByManual()))
                .collect(Collectors.toList());
        System.out.println();
        return lottoList;
    }
}
