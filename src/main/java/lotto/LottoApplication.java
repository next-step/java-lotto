package lotto;

import lotto.controller.LottoController;

public final class LottoApplication {

    public static void main(String[] args) {
        try {
            new LottoController().run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
