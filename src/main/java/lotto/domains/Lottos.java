package lotto.domains;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int count() {
        return lottoList.size();
    }

    public void printLottosNumbers() {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.lottoNumbers());
        }
    }

    public LottoStatistics getStatistics(LottoNumbers winningLottoNumbers) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        for (Lotto lotto : lottoList) {
            lottoStatistics.add(lotto.matchingNumberCount(winningLottoNumbers));
        }
        return lottoStatistics;
    }
}
