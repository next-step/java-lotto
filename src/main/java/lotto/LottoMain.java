package lotto;

import lotto.controller.LottoController;

public class LottoMain {

    public static void main(String[] args) {

        LottoController lottoController = new LottoController();
        try {
            lottoController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
