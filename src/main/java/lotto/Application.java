package lotto;

import lotto.controller.Lottery;

public class Application {

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        lottery.draw();
    }
}
