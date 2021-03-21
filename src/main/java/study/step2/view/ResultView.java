package study.step2.view;

import java.util.List;

import study.step2.domain.Lotto;

public class ResultView {
    private final static String MESSAGE_PURCHASE_COUNT = "개를 구입하셨습니다.";
    private final static String MESSAGE_WIN_RESULT = "당첨 통계\n---------";

    public static void printPurchaseCount(int count) {
        System.out.println(count + MESSAGE_PURCHASE_COUNT);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> {
            System.out.println(lotto.getLottoNumbers());
        });
        System.out.println();
    }
}
