package lotto.view;

import lotto.Lotto;

public class ResultView {

    public static final String QUANTITY_RESULT_MESSAGE = "개를 구입했습니다.";

    public static void printQuantity(int quantity) {
        System.out.println(quantity + QUANTITY_RESULT_MESSAGE);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.lottoNumbers());
    }
}
