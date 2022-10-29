package lotto;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputManualLottoQuantity;
import static lotto.view.InputView.inputManualLottos;
import static lotto.view.InputView.inputMoney;
import static lotto.view.InputView.inputWinningLotto;
import static lotto.view.OutputView.printLottos;
import static lotto.view.OutputView.printResult;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStorage;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.strategy.AutoIssueLottoStrategy;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = new Money(inputMoney());
        int manualQuantity = inputManualLottoQuantity();
        List<String> manualLottos = inputManualLottos();

        LottoStore store = LottoStore.getInstance();
        LottoStorage storage = store.buyLotto(money, AutoIssueLottoStrategy.getInstance());
        printLottos(storage.getLottos());

        Lotto winningLotto = new Lotto(inputWinningLotto());
        LottoNumber bonusNumber = inputBonusNumber(winningLotto);

        storage.matchAllWithWinningLotto(winningLotto, bonusNumber);

        printResult(storage.getResult(), storage.getProfit());
    }
}
