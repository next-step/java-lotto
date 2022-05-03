package lotto;

import lotto.controller.LottoController;
import lotto.pattern.AutoLottoNumberGenerator;

public class LottoApp {
    public static void main(String[] args) {
        new LottoController(AutoLottoNumberGenerator.getInstance()).autoLottoProgram();
    }
}
