package lotto;

import calculator.controller.CalculatorManager;
import lotto.controller.LottoAutomaticManager;

public class LottoAutomaticApplication {
    public static void main(String[] args) {
        LottoAutomaticManager lottoPlayer = new LottoAutomaticManager();
        lottoPlayer.start();
    }
}
