package lotto.view;

import lotto.domain.LottoGame;

public class ResultView {
    private static final String ANSWER_COUNT_LOTTO_MESSAGE = "개 를 구입 했습니다.";

    private ResultView() {
    }

    public static void printPurchaseLottoCount(int count) {
        System.out.println(count + ANSWER_COUNT_LOTTO_MESSAGE);
    }
}
