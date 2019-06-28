import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new LottoMoney(InputView.inputBuyPrice()));
        List<LottoSet> lottoSets = lottoGame.start();
        ResultView.printBuyLottoPaper(lottoSets);
        LottoResult lottoResult = new LottoResult(lottoSets, new WinningLotto(InputView.inputWinningLotto(), InputView.inputBonusNumber()));
        ResultView.printLottoResult(lottoResult);
    }
}
