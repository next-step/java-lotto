import domain.*;
import ui.InputView;
import ui.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        Money buyingAmount = Money.of(InputView.askMoneyAmount());
        Money lottoPrice = Money.of(Lotto.LOTTO_PRICE);
        int numberOfLottos = (int) Math.floor(buyingAmount.dividedBy(lottoPrice));
        int numberOfManualLottos = InputView.askNumberOfManualLottos();

        Lottos manualLottos = Lottos.of(InputView.askManualLottoNumbers(numberOfManualLottos));
        Lottos autoLottos = Lottos.of(numberOfLottos - numberOfManualLottos);

        Lottos lottos = manualLottos.addAll(autoLottos);

        ResultView.printBuyingLottos(lottos, numberOfManualLottos);

        Lotto winningLotto = Lotto.of(InputView.askWinningNumbers());
        int bonusNumber = InputView.askBonusNumber();

        LottoResult lottoResult = lottos.calculate(winningLotto, bonusNumber);
        ResultView.printLottoResult(lottoResult);
    }
}
