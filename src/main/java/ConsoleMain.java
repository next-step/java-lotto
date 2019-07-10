import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public final class ConsoleMain {
    public static void main(String[] args) {
        int buyPrice = InputView.inputBuyPrice();
        int manualBuyNumber = InputView.inputManualBuyNumber();
        LottoGame lottoGame = new LottoGame(buyPrice, manualBuyNumber);
        List<LottoSet> manualLottoSets = InputView.inputManualLottoSets(manualBuyNumber);
        LottoPaper lottoPaper = new LottoPaper(manualLottoSets, lottoGame.start());
        ResultView.printBuyLottoPaper(lottoPaper);
        WinningLotto winningLotto = new WinningLotto(InputView.inputWinningLotto(), InputView.inputBonusNumber());
        ResultView.printLottoResult(new RankCount(lottoPaper, winningLotto));
    }
}
