package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Game {


    public static void main(String args[]) {
        InputView inputView = new InputView();
        inputView.exec();

        ResultView resultView = new ResultView();
        resultView.exec();
    }

}
