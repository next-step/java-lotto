import domain.*;
import view.InputView;
import view.ResultView;

public final class ConsoleMain {
    public static void main(String[] args) {
        int buyPrice = InputView.inputBuyPrice();
        int manualBuyNumber = InputView.inputManualBuyNumber();
        LottoGame lottoGame = new LottoGame(new LottoMoney(buyPrice), manualBuyNumber);
        LottoPaper lottoPaper = new LottoPaper(InputView.inputManualAutoSets(manualBuyNumber), lottoGame.start());
        ResultView.printBuyLottoPaper(lottoPaper);
        WinningLotto winningLotto = new WinningLotto(InputView.inputWinningLotto(), InputView.inputBonusNumber());
        LottoResult lottoResult = new LottoResult(lottoPaper, winningLotto);
        ResultView.printLottoResult(lottoResult);
    }
}
