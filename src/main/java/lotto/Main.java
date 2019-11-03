package lotto;

import lotto.controller.LottoMachine;
import lotto.view.LottoView;

public class Main {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new LottoView());
        lottoMachine.start();
    }
}
