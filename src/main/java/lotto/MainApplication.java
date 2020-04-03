package lotto;

import lotto.view.InputView;

public class MainApplication {
    public static void main(String[] args) {
        InputView.getMoney();
        InputView.getManualLottoCount();
        InputView.getManualLottos();
        InputView.getWinningLottoNumbers();
        InputView.getBonusBallNumber();
    }
}