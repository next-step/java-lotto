import domain.LottoGame;
import domain.LottoNumberGenerator;
import utils.InputView;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new LottoNumberGenerator());
        lottoGame.run(InputView.inputPurchaseAmount(), InputView.inputWinningNumbers(), InputView.inputBonusNumber());
    }
}
