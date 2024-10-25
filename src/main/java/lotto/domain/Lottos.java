package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public static Lottos createLottos(int autoAmount, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = lottoGenerator.generateLottos(autoAmount);
        return new Lottos(lottos);
    }

    public static Lottos createLottosByManual(List<Lotto> lottos) {
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

    public LottoResultStatistic getResultStatistic(WinningLotto winningLotto) {
        LottoResultStatistic statistic = new LottoResultStatistic();
        for (Lotto lotto : lottos) {
            int count = lotto.lottoWinningStatus(winningLotto.getWinningLotto());
            boolean bonusHit = lotto.checkContainsBonusNumber(winningLotto.getBonusLottoNumber());
            statistic.updatePrize(Prize.getHit(count, bonusHit));
        }
        return statistic;
    }

    public void additionalLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void additionalLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> this.lottos.add(lotto));
    }

}
