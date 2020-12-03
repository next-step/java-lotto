package lotto.automatic;

import lotto.automatic.view.InputView;
import lotto.automatic.view.OutputView;

public class LottoMainApp {

    public static void main(String ...args) {

        LottoController controller = new LottoController(new InputView(), new OutputView());

        controller.request();

    }

}
