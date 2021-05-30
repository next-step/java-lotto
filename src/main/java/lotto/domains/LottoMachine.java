package lotto.domains;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    /*
    * TODO
    *  PurchasingInfo(구압가격, 수동로또갯수, 수동로또번호리스트) 를 받아
    *  수동로또 오토로또 생성
    */

    private LottoMachine() {}

    public static Lottos makeLottos(Cash cash) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < cash.numberOfPurchasesAvailable(); i++) {
            lottoList.add(new Lotto());
        }
        return new Lottos(lottoList);
    }

    public static Lottos makeLottos(PurchasingInfo purchasingInfo) {
        List<Lotto> lottoList = new ArrayList<>();
        makeAutomaticLottos(lottoList, purchasingInfo);
        makeManualLottos(lottoList, purchasingInfo);
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
