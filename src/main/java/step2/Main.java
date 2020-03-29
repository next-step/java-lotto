package step2;

import step2.controller.LottoMachine;
import step2.view.InputView;

public class Main {

    public static void main(String[] args) {
        LottoMachine.getInstance().operate(InputView.getInstance());
    }
}
