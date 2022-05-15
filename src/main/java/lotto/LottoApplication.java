package lotto;

import lotto.controller.GameController;

import static lotto.controller.GameController.GameType.MANUAL;

public class LottoApplication {
    public static void main(String[] args) {
        GameController.start(MANUAL);
    }
}
