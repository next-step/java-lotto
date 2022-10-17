package lotto;

import static lotto.view.InputView.inputMoney;
import static lotto.view.InputView.inputWinningLotto;
import static lotto.view.OutputView.printLottos;
import static lotto.view.OutputView.printResult;

import lotto.domain.Lotto;
import lotto.domain.LottoStorage;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.strategy.AutoIssueLottoStrategy;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = new Money(inputMoney());
        LottoStore store = LottoStore.getInstance();
        LottoStorage storage = store.buyLotto(money, AutoIssueLottoStrategy.getInstance());
        printLottos(storage.getLottos());

        Lotto winningLotto = new Lotto(inputWinningLotto());
        storage.matchAllWithWinningLotto(winningLotto);

        printResult(storage.getResult(), storage.getProfit());
    }
}
