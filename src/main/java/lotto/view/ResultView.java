package lotto.view;

import lotto.domain.Lotto;

public class ResultView {
    private ResultView() {
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.value());
    }
}
