import domain.LottoGame;
import domain.LottoResult;
import domain.Money;
import domain.WinningLotto;
import view.InputView;
import view.ResultView;

public class MainApplication {

    public static void main(String[] args) {
        int moneyAmount = InputView.getAmount();

        Money money = new Money(moneyAmount);

        LottoGame lottoGame = new LottoGame(money.ticketCount());
        ResultView.printLottos(lottoGame);

        WinningLotto winningLotto = new WinningLotto(InputView.getWinningNumbers(), InputView.getBonusNumber());
        LottoResult result = lottoGame.playingLotto(winningLotto);

        ResultView.printLottoResult(result, money);
    }
}
