import domain.*;
import ui.InputView;
import ui.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) throws Exception {
        Money buyingAmount = Money.of(InputView.askMoneyAmount());
        Money lottoPrice = Money.of(Lotto.LOTTO_PRICE);
        int numberOfLottos = (int) Math.floor(buyingAmount.dividedBy(lottoPrice));
        int numberOfManualLottos = InputView.askNumberOfManualLottos();

        List<Lotto> manualLottos = LottoGenerator.generate(InputView.askManualLottoNumbers(numberOfManualLottos));
        List<Lotto> autoLottos = LottoGenerator.generate(numberOfLottos - numberOfManualLottos);

        Lottos lottos = new Lottos(manualLottos);
        lottos = lottos.addAll(autoLottos);

        ResultView.printBuyingLottos(lottos, numberOfManualLottos);

        Lotto winningLotto = Lotto.of(InputView.askWinningNumbers());
        int bonusNumber = InputView.askBonusNumber();

        LottoResult lottoResult = lottos.calculate(winningLotto, bonusNumber);
        ResultView.printLottoResult(lottoResult);
    }
}
