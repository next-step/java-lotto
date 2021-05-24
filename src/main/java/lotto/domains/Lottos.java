package lotto.domains;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int count() {
        return lottoList.size();
    }

    public LottoStatistics getStatistics(LottoNumbers winningLottoNumbers) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        for (Lotto lotto : lottoList) {
            lottoStatistics.add(lotto.matchingNumberCount(winningLottoNumbers));
        }
        return lottoStatistics;
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(this.lottoList);
    }
}
