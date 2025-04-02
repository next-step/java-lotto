import domain.LottoGame;
import domain.LottoNumberGenerator;
import domain.Lottos;
import utils.InputView;

import static utils.Parser.toInt;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new LottoNumberGenerator());
        String amountInput = InputView.inputPurchaseAmount();
        int purchaseAmount = toInt(amountInput);
        int lottoCount = InputView.inputManualLottoCount();
        Lottos lottos = lottoGame.buyLotto(purchaseAmount, lottoCount, InputView.inputManualLotto(lottoCount));
        lottoGame.displayStatistic(purchaseAmount, InputView.inputWinningNumbers(), InputView.inputBonusNumber(), lottos);
    }
}
