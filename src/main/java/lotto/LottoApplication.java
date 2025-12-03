package lotto;

import lotto.controller.LottoController;
import lotto.model.*;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.run();
    }
}
