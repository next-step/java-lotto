package lotto;

import lotto.view.LottoInput;
import lotto.model.Lottery;
import lotto.model.Lotto;
import lotto.model.constants.Dividend;
import lotto.view.LottoOutput;

import java.util.List;

import static lotto.model.LottoFactory.*;

public class simulator {
    public static void main(String[] args) {
        LottoApplication application = new LottoApplication(new LottoInput(), new LottoOutput());
        application.run();
    }
}
