package lotto.view;

import lotto.Lotto;

public class Outputview {
    public static void printPurchasedAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }
}
