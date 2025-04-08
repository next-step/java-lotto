package domain;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoList;
    private final LottoStatistics lottoStatistics;

    public LottoBundle(List<Lotto> lottoList, WinningNumbers winningNumbers) {
        this.lottoList = lottoList;
        this.matchRank(winningNumbers);
        this.lottoStatistics = new LottoStatistics(lottoList);
    }

    public LottoStatistics getLottoStatics() {
        return lottoStatistics;
    }

    private void matchRank(WinningNumbers winningNumbers){
        for(Lotto lotto : lottoList){
            lotto.matchRank(winningNumbers);
        }
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
