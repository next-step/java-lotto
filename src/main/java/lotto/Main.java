package lotto;

import lotto.controller.LottoMachine;
import lotto.view.LottoView;

public class Main {

    public static void main(String[] args) {
        LottoMachine.getInstance().start(LottoView.getInstance());
    }
}
