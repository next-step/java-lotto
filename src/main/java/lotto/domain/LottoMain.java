package lotto.domain;

import lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        try {
            int money = InputView.getMoneyToBuyLotto();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
