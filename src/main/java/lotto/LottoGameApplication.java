package lotto;

import lotto.data.LottoBall;
import lotto.data.LottoPurchaseInfo;
import lotto.domain.Lotto;
import lotto.domain.LottoSheet;
import lotto.domain.WinLottoBalls;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        Input input = new Input();
        int lottoPurchasePrice = input.getLottoPurchaseMoneyInput();
        int manualCount = input.getLottoManualCountInput();
        List<List<Integer>> lottoManual = new ArrayList<>();
        if (manualCount > 0) {
             lottoManual = input.getLottoManual(manualCount);
        }

        LottoSheet lottoSheet = new LottoSheet(
                new LottoPurchaseInfo(lottoPurchasePrice, lottoManual)
        );

        Output output = new Output();
        output.printPurchaseResult(lottoSheet);

        Lotto lastWeekWinningLottoNumbers = new Lotto(input.getLastWeekWinningLottoNumbersInput());
        LottoBall bonusNumber = LottoBall.selectLottoBall(input.getBonusNumber());
        output.printWinningResult(lottoSheet.matchWin(
                new WinLottoBalls(lastWeekWinningLottoNumbers, bonusNumber)
        ));
    }
}
