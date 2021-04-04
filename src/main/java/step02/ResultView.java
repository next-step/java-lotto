package step02;

import static step02.LottoConfig.*;

public class ResultView {

    private ResultView() {}

    public static void showBuyLottoResult(Lottos lottos) {
        System.out.println(lottos.getLottoCount().getCount() + BUY_N_COUNT);
        System.out.println(lottos.toString());
    }

    public static void showLottoWinnerResult() {

    }
}
