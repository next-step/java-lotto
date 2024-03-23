package lotto;

import lotto.common.LottoInputParser;
import lotto.domian.*;
import lotto.ui.InputHandler;
import lotto.ui.OutputHandler;

public class LottoApplication {
    public static void main(String[] args) {
        OutputHandler output = new OutputHandler();
        InputHandler input = InputHandler.of();
        LottoNumberGenerator generator = new LottoNumberGenerator();
        LottoShop lottoShop = LottoShop.of(generator);

        LottoController controller = LottoController.of(output, input, lottoShop);
        controller.run();
    }
}
