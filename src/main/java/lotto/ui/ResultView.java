package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    private static final String COUNT_OF_PURCHASE_MESSAGE = "%s개를 구매했습니다.";
    private static final String LINE_SEPARATOR = "line.separator";

    private ResultView() {
    }

    public static void printCountOfLottos(int count) {
        System.out.println(String.format(COUNT_OF_PURCHASE_MESSAGE, count));
    }

    public static void printResultOfPurchase(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.getLottoNumbers());
            stringBuilder.append(System.getProperty(LINE_SEPARATOR));
        }
        System.out.println(stringBuilder.toString());
    }
}
