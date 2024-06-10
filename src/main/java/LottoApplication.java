import lotto.InputView;
import lotto.LottoController;
import lotto.OutputView;

import java.io.IOException;

public class LottoApplication {
    public static void main(String[] args) throws IOException {
        LottoController lottoController = new LottoController();
        OutputView outputView = new OutputView(lottoController);

        while (true) {
            int money = InputView.requestUserPrice();
            outputView.showLottos(money);
        }
    }
}