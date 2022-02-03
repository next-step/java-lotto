package lotto.view;

import lotto.util.LottoGenerator;

public class ResultView {

    public static void printLottoQuantity(int purchasePrice) {
        final int quantity = LottoGenerator.getLottoQuantity(purchasePrice);
        System.out.println(quantity + "개를 구매했습니다.");
    }
}
