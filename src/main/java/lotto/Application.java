package lotto;

import lotto.domain.CanNotBuyLottoException;
import lotto.domain.Cashier;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Cashier cashier = createCashier();
        int playLottoCount = cashier.findCountOfPlayLotto();
        List<Lotto> lottos = LottoGenerator.generate(playLottoCount);

        OutputView.printGeneratedLottos(lottos);
    }

    private static Cashier createCashier() {
        try {
            return new Cashier(InputView.receiveMoney());
        } catch (CanNotBuyLottoException e) {
            System.out.println(e.getMessage());
            return createCashier();
        }
    }
}
