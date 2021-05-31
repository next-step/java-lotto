package lotto.domains;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private LottoMachine() {
    }

    public static Lottos makeLottos(PurchasingInfo purchasingInfo) {
        List<Lotto> lottoList = new ArrayList<>();
        makeManualLottos(lottoList, purchasingInfo);
        makeAutomaticLottos(lottoList, purchasingInfo);
        return new Lottos(lottoList);
    }

    private static void makeAutomaticLottos(List<Lotto> lottoList, PurchasingInfo purchasingInfo) {
        for (int i = 0; i < purchasingInfo.autoLottoCount(); i++) {
            lottoList.add(new Lotto());
        }
    }

    private static void makeManualLottos(List<Lotto> lottoList, PurchasingInfo purchasingInfo) {
        for (String stringLottoNumber : purchasingInfo.manualLottoList()) {
            lottoList.add(new Lotto(stringLottoNumber));
        }
    }
}
