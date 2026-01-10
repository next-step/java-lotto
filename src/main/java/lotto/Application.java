package lotto;

import lotto.application.LottoMachine;
import lotto.domain.generator.ShuffleNumberGenerator;
import lotto.ui.InputView;
import lotto.ui.LottoController;
import lotto.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine(new ShuffleNumberGenerator());
        LottoController controller = new LottoController(new InputView(), new ResultView(), machine);
        controller.run();
    }
}
