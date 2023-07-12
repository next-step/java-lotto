package lotto;

import lotto.controller.LottoController;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            new LottoController().run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
