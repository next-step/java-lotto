package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.NormalLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMachineController {

    public static void main(String[] args) {
        List<NormalLotto> purchasedLottos = purchaseLotto();
        ResultView.printPurchasedLottos(purchasedLottos);
        Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        int winningBonusNumber = InputView.inputWinningBonusNumber();
        WinningLotto winningLotto = LottoFactory.createWinning(winningNumbers, winningBonusNumber);

        LottoResult lottoResult = new LottoResult(purchasedLottos, winningLotto);
        ResultView.printWinningStatistics(lottoResult.getWinningLottoCounts());
        ResultView.printEarningRate(lottoResult.getEarningRate());
    }

    private static List<NormalLotto> purchaseLotto() {
        int totalAmount = InputView.inputTotalAmount();
        int possiblePurchaseLottoCount = LottoFactory.possiblePurchaseLottoCount(totalAmount);
        int purchaseManualLottoCount = InputView.inputManualLottoCount();

        List<NormalLotto> manualLottos = purchaseManualLotto(purchaseManualLottoCount);
        List<NormalLotto> randomLottos = purchaseNormalLotto(possiblePurchaseLottoCount - purchaseManualLottoCount);

        return Stream.concat(manualLottos.stream(), randomLottos.stream())
            .collect(Collectors.toList());
    }

    private static List<NormalLotto> purchaseManualLotto(int count) {
        ResultView.printString("수동으로 구매할 번호를 입력해 주세요.");
        List<NormalLotto> manualLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            NormalLotto normalLotto = LottoFactory.createNormal(InputView.inputManualNumbers());
            manualLottos.add(normalLotto);
        }

        return manualLottos;
    }

    private static List<NormalLotto> purchaseNormalLotto(int count) {
        List<NormalLotto> normalLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            normalLottos.add(LottoFactory.createNormal());
        }

        return normalLottos;
    }
}
