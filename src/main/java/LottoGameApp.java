import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoGameApp {
    public static void main(String[] args) {

        int money = InputView.getMoney();
        List<Lotto> manualLotto = InputView.getManualLotto();

        LottoGame lottoGame = LottoGame.of(money, manualLotto);

        OutputView.printLottoGames(lottoGame);

        String winningNumberStr = InputView.getWinningNumberString();
        String bonusLottoNumber = InputView.getBonusNumber();

        WinningInfos winningInfos = lottoGame.getWinningInfos(winningNumberStr, bonusLottoNumber);

        OutputView.printResult(money, winningInfos);
    }
}
