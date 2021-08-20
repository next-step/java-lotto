package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private Lottos lottos;

    public LottoManager() {
        this(0);
    }

    public LottoManager(int purchaseAmount) {
        makeLottos(getPurchaseLottoCount(purchaseAmount), 0);
    }

    public LottoManager(int purchaseAmount, int manualLottoCount) {
        makeLottos(getPurchaseLottoCount(purchaseAmount - LottoPrice.LOTTO_PRICE * manualLottoCount), manualLottoCount);
    }

    private void makeLottos(int autoLottoCount, int manualLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < autoLottoCount; i++) {
            lottoList.add(new Lotto(new AutoNumberStrategy()));
        }
        System.out.println("수동으로 구매할 번호를 입력해주세요");
        for (int i = 0; i < manualLottoCount; i++) {
            lottoList.add(makeLotto(new ManualNumberStrategy()));
        }
        this.lottos = new Lottos(lottoList);
    }

    public Lottos getLottos() {
        return this.lottos;
    }

    public int getPurchaseLottoCount(int purchaseAmount) {
        return Lotto.calcPurchaseLottoCount(purchaseAmount);
    }

    public Lotto makeLotto(PickNumberStrategy pickNumberStrategy) {

        while (true) {
            try {
                Lotto lotto = new Lotto(pickNumberStrategy);
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 로또 값을 입력하였습니다. 6개의 숫자를 입력해주세요.");
            }
        }
    }

    public BonusBall makeBonusBall(int bonusBall) {
        return new BonusBall(bonusBall);
    }

    public WinningStatistics makeWinningLottoResult(WinningLotto winningLotto) {
        lottos.makeWinningLottoResult(winningLotto);
        return lottos.getWinningStatistics();
    }

    public double getLottoYield(int purchaseAmount) {
        return lottos.calcLottoYield(Lotto.calcPurchaseLottoCount(purchaseAmount) * LottoPrice.LOTTO_PRICE);
    }
}
