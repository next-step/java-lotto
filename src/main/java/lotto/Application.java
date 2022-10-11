package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Cashier cashier = createCashier();
        int playLottoCount = cashier.findCountOfPlayLotto();
        List<Lotto> lottos = LottoGenerator.generate(playLottoCount);
        OutputView.printGeneratedLottos(lottos);

        Lotto lastWeekWinningLotto = Lotto.of(InputView.receiveLastWeekWinningNumber());
    }

    private static Cashier createCashier() {
        try {
            return new Cashier(InputView.receiveMoney());
        } catch (RuntimeException e) {
            return createCashier();
        }
    }
}
