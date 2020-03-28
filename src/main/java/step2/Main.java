package step2;

import step2.controller.LottoMachine;
import step2.domain.Lottos;
import step2.view.InputView;
import step2.view.ResultView;

public class Main {

    public static void main(String[] args) {
        LottoMachine.operate(InputView.getInstance());
    }
}
