import domain.LottoGame;
import domain.LottoResult;
import domain.Price;
import view.InputView;
import view.ResultView;

public class MainApplication {

    public static void main(String args[]) {
        int moneyAmount = InputView.getAmount();

        Price price = new Price(moneyAmount);

        LottoGame lottoGame = new LottoGame(price.ticketCount());
        ResultView.printLottos(lottoGame);

        String winningNumbers = InputView.getWinningNumbers();
        LottoResult result = lottoGame.playingLotto(winningNumbers, price);
        ResultView.printLottoResult(result);
    }
}
