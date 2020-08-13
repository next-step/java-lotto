package view;

import domain.Lotto;

import java.util.List;

public class ResultView {
    public static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void viewBuyAmount(int buyAmount) {
        System.out.println(buyAmount + BUY_AMOUNT_MESSAGE);
    }

    public static void viewIssuedLotto(List<Lotto> issue) {
        for (Lotto lotto : issue) {
            System.out.println(lotto.getNumbers());
        }
    }
}
