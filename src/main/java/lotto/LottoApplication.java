package lotto;

import lotto.controller.LottoMachine;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.start();
    }
}
