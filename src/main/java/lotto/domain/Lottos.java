package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final PurchaseInfo purchaseInfo;

    public static Lottos createLottos(PurchaseInfo purchaseInfo, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseInfo.getNumberOfAutoPurchase());
        return new Lottos(lottos, purchaseInfo);
    }

    public static Lottos createLottosByManual(List<Lotto> lottos, PurchaseInfo purchaseInfo) {
        return new Lottos(lottos, purchaseInfo);
    }

    private Lottos(List<Lotto> lottos, PurchaseInfo purchaseInfo) {
        this.lottos = lottos;
        this.purchaseInfo = purchaseInfo;
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResultStatistic getResultStatistic(WinningLotto winningLotto) {
        LottoResultStatistic statistic = new LottoResultStatistic();
        for (Lotto lotto : lottos) {
            int count = lotto.lottoWinningStatus(winningLotto.getWinningLotto());
            boolean bonusHit = lotto.checkContainsBonusNumber(winningLotto.getBonusLottoNumber());
            statistic.updatePrize(Prize.getHit(count,bonusHit));
        }
        return statistic;
    }

    public void additionalLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public void additionalLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> this.lottos.add(lotto));
    }

    public PurchaseInfo getPurchaseInfo() {
        return purchaseInfo;
    }
}
