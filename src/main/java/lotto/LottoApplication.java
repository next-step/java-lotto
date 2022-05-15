package lotto;

import lotto.controller.GameController;

import static lotto.controller.GameController.GameType.BONUS;

public class LottoApplication {
    public static void main(String[] args) {
        GameController.start(BONUS);
    }
}
