package lotto;

import lotto.controller.LottoApplication;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class simulator {
    public static void main(String[] args) {
        LottoApplication application = new LottoApplication(new LottoInput(), new LottoOutput());
        application.run();
    }
}
