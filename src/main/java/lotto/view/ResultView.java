package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.List;

public final class ResultView {

    private static final String NEW_LINE = "\n";

    private ResultView() {
    }

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        StringBuilder builder = new StringBuilder();
        lottoNumbers.forEach(lotto -> builder.append(lotto).append(NEW_LINE));

        System.out.println(builder.append(NEW_LINE));
    }
}
