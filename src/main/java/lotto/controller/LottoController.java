package lotto.controller;

import lotto.model.WinningInfo;
import lotto.service.LottoBuyer;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoController {
    public static void main(String[] args) {
        LottoBuyer lottoBuyer = new LottoBuyer();

        System.out.println("구입금액을 입력해 주세요.");
        int buyAmount = InputView.inputBuyAmount();

        System.out.println("\n수동으로 구매할 로또 수를 입력해주세요.");
        int manualLottoCount = InputView.inputManualLottoCount(buyAmount);
        int autoLottoCount = LottoBuyer.calculateAutoLottoCount(buyAmount, manualLottoCount);

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for (int count = 1; count <= manualLottoCount; count++) {
            lottoBuyer.buyManualLotto(InputView.inputManualLottoNumbers());
        }

        for (int count = 1; count <= autoLottoCount; count++) {
            lottoBuyer.buyAutoLotto();
        }

        ResultView.printBuyLottoCount(manualLottoCount, autoLottoCount);
        ResultView.printBoughtLottos(lottoBuyer.getBoughtLottos());

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = InputView.inputWinningNumbers();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        Map<Integer, WinningInfo> winningStatics = lottoBuyer.checkLottoResult(winningNumbers, bonusNumber);
        ResultView.printWinningStatics(winningStatics);

        float returnRate = lottoBuyer.checkReturnRate(buyAmount);
        ResultView.printReturnRate(returnRate);
    }
    
}