package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private static final int LOTTO_PRICE = 1000;

    private Lottos lottos;

    public LottoManager() {
    }

    public LottoManager(int purchaseAmount) {
        getPurchaseLottoCount(purchaseAmount);
        makeLottos(getPurchaseLottoCount(purchaseAmount));
    }

    public void makeLottos(int purchaseLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseLottoCount; i++) {
            lottoList.add(new Lotto(new AutoNumberStrategy()));
        }
        this.lottos = new Lottos(lottoList);
    }

    public Lottos getLottos() {
        return this.lottos;
    }


    public static int getPurchaseLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public Lotto makeWinningLotto() {
        Lotto lotto = new Lotto(new ManualNumberStrategy());
        return lotto;
    }
}
