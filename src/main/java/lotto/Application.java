package lotto;

import lotto.InputView;
import lotto.ResultView;

public class Application {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine(new ShuffleNumberGenerator());
        LottoController controller = new LottoController(new InputView(), new ResultView(), machine);
        controller.run();
    }
}
