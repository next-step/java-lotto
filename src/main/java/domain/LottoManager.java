package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private Lottos lottos;

    public LottoManager() {
        this(0, new int[0][LottoNumbers.LOTTO_NUM_COUNT]);
    }

    public LottoManager(int autoLottoCount, int[][] manualLottos) {
        makeLottos(autoLottoCount, manualLottos);
    }


    private void makeLottos(int autoLottoCount, int[][] manualLottos) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < autoLottoCount; i++) {
            lottoList.add(new Lotto(new AutoNumberStrategy()));
        }
        for (int i = 0; i < manualLottos.length; i++) {
            lottoList.add(makeLotto(new ManualNumberStrategy(manualLottos[i])));
        }
        this.lottos = new Lottos(lottoList);
    }

    public Lottos getLottos() {
        return this.lottos;
    }

    public static Lotto makeLotto(PickNumberStrategy pickNumberStrategy) {
        return new Lotto(pickNumberStrategy);
    }

    public static LottoNumber makeLottoNumber(int number) {
        return new LottoNumber(number);
    }

    public WinningStatistics makeWinningLottoResult(WinningLotto winningLotto) {
        lottos.makeWinningLottoResult(winningLotto);
        return lottos.getWinningStatistics();
    }

    public double getLottoYield(int purchaseAmount) {
        return lottos.calcLottoYield(Lotto.calcPurchaseLottoCount(purchaseAmount) * LottoPrice.LOTTO_PRICE);
    }
}
