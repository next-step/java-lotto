package step2;

import java.util.Arrays;

public class LottoResultView {
    public static void outputLottos(Lottos lottos) {
        System.out.println(lottos.getPurchaseLottoSize() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.printLotto().toArray()));
        }
    }
}
