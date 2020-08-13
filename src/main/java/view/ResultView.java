package view;

import domain.Lotto;
import domain.Lottos;

import java.util.List;

public class ResultView {
    public static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void viewBuyAmount(int buyAmount) {
        System.out.println(buyAmount + BUY_AMOUNT_MESSAGE);
    }

    public static void viewIssuedLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getValue()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
