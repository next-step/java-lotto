package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoResult;

import lotto.view.ConsoleView;

public class LottoApplication {
    public static void main(String[] args){
        LottoController lottoController = new LottoController();
        LottoResult lottoResult = lottoController.run();
        ConsoleView consoleView = new ConsoleView(lottoResult);
        consoleView.print();

    }
}
