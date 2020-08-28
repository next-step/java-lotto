import domain.*;
import view.InputView;
import view.OutputView;

public class LottoGameApp {
    public static void main(String[] args) {

        int money = InputView.getMoney();

        LottoGame lottoGame = LottoGame.of(money);

        OutputView.printLottoGames(lottoGame);

        String winningNumberStr = InputView.getWinningNumberString();
        String bonusLottoNumber = InputView.getBonusNumber();

        WinningInfos winningInfos = lottoGame.getWinningInfos(winningNumberStr, bonusLottoNumber);

        OutputView.printResult(money, winningInfos);
    }
}
