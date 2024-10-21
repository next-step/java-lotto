package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public static Lottos createLottos(int purchaseAmount, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        return new Lottos(lottos);
    }

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResultStatistic getWinningPrize(WinningLotto winningLotto) {
        LottoResultStatistic statistic = new LottoResultStatistic();
        for (Lotto lotto : lottos) {
            int count = lotto.lottoWinningStatus(winningLotto);
            boolean bonusHit = lotto.contains(winningLotto.getBonusLottoNumber());
            statistic.updatePrize(Prize.getHit(count),Prize.getValueByHit(count,bonusHit));
        }
        return statistic;
    }

    public void additionalLotto(Lotto lotto){
        lottos.add(lotto);
    }

}
