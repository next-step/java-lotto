package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        int manualLottoCount = InputView.getManualLottoCount();
        List<List<Integer>> manualLottoNumbers = InputView.getManualLottoNumbers(manualLottoCount);
        LottoMachine machine = new LottoMachine();
        LottoPurchase lottoPurchase = machine.buy(purchaseAmount, manualLottoNumbers);
        ResultView.printLottoPurchase(lottoPurchase);
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        LottoWinnings lottoWinnings = new LottoWinnings(winningNumbers, bonusNumber);
        LottoResult result = new LottoResult(lottoPurchase, lottoWinnings);
        ResultView.printResult(result);
    }
}
