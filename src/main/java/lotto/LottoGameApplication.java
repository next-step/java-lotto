package lotto;

import lotto.data.LottoBall;
import lotto.domain.Lotto;
import lotto.domain.LottoSheet;
import lotto.domain.WinLottoBalls;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGameApplication {

    public static void main(String[] args) {
        Input input = new Input();
        int lottoPurchaseMoney = input.getLottoPurchaseMoneyInput();

        LottoSheet lottoSheet = new LottoSheet(lottoPurchaseMoney);

        Output output = new Output();
        output.printPurchaseResult(lottoSheet);

        Lotto lastWeekWinningLottoNumbers = new Lotto(input.getLastWeekWinningLottoNumbersInput());
        LottoBall bonusNumber = LottoBall.selectLottoBall(input.getBonusNumber());
        output.printWinningResult(lottoSheet.matchWin(
                new WinLottoBalls(lastWeekWinningLottoNumbers, bonusNumber)
        ));
    }
}
