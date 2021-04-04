package step02;

import static step02.LottoConfig.*;

public class ResultView {

    private ResultView() {}

    public static void showLottoResult(Lottos lottos) {
        System.out.println(lottos.getLottoCount().getCount() + BUY_N_COUNT);
        System.out.println(lottos.toString());
    }

//    private static void showLottoCount() {
//        System.out.println(lottos.getLottoCount().getCount() + BUY_N_COUNT);
//    }
}
