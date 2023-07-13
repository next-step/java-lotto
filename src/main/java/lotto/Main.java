package lotto;

import lotto.controller.LottoController;

public class Main {

    public static void main(String[] args) {
        try {
            new LottoController().run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
