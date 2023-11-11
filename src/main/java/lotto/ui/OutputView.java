package lotto.ui;

import lotto.ui.dto.MyLottosResponse;

public class OutputView {
    public static void outputPurchaseCount(int purchaseCount) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
    }

    public static void outputMyLottos(MyLottosResponse myLottosResponse) {
        myLottosResponse.getLottos()
                .forEach((lottoResponse) -> System.out.println(lottoResponse.getNums()));
    }
}
