package lotto.domain;

import lotto.exception.PrizeOverFlowIsNegativeException;

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

    public int getWinningPrize(Lotto winningLotto) {
        int totalPrize = 0;
        int eachPrize = 0;
        for (Lotto lotto : lottos) {
            eachPrize = lotto.lottoWinningStatus(lotto, winningLotto);
            validOverFlow(eachPrize, totalPrize);
            validtotalPrize(eachPrize, totalPrize);
            totalPrize += eachPrize;
        }
        return totalPrize;
    }

    private void validtotalPrize(int eachPrize, int totalPrize) {
        if (eachPrize + totalPrize > 2_000_000_000) {
            throw new IllegalArgumentException("총 상금 20억을 넘길 순 없음");
        }
    }

    private void validOverFlow(int eachPrize, int totalPrize) {
        if (eachPrize + totalPrize < 0) {
            throw new PrizeOverFlowIsNegativeException();
        }
    }

    public void additionalLotto(Lotto lotto){
        lottos.add(lotto);
    }

}
