import domain.LottoGame;
import domain.LottoNumberGenerator;
import domain.Lottos;
import utils.InputView;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new LottoNumberGenerator());
        String amount = InputView.inputPurchaseAmount();
        int lottoCount = InputView.inputManualLottoCount();
        Lottos lottos = lottoGame.buyLotto(amount, lottoCount, InputView.inputManualLotto(lottoCount));
        lottoGame.displayStatistic(amount, InputView.inputWinningNumbers(), InputView.inputBonusNumber(), lottos);
    }
}
