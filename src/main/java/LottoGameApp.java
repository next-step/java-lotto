import domain.LottoGame;
import domain.WinningInfos;
import view.InputView;
import view.OutputView;

public class LottoGameApp {
    public static void main(String[] args) {

        int money = InputView.getMoney();
        LottoGame lottoGame = InputView.getLottoGame(money);
        OutputView.printLottoGames(lottoGame);

        WinningInfos winningInfos = InputView.getWinningInfos(lottoGame);
        OutputView.printResult(money, winningInfos);
    }
}
