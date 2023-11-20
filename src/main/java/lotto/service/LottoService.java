package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchPointRank;

import java.util.List;

public class LottoService {

    private final List<Lotto> lottoList;
    private final MatchPointRank matchPointRank;

    public LottoService(List<Lotto> lottoList, MatchPointRank matchPointRank) {
        this.lottoList = lottoList;
        this.matchPointRank = matchPointRank;
    }

    public void playLotto(String[] winningNum) {
        this.compareLottoWinningNumber(winningNum);

        for (Lotto lotto : lottoList) {
            matchPointRank.compareMatchPoint(lotto);
        }
    }

    private void compareLottoWinningNumber(String[] winningNum) {
        for (Lotto lotto : this.lottoList) {
            lotto.compareWinningNumber(winningNum);
        }
    }

    public MatchPointRank getMatchPointMap() {
        return this.matchPointRank;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
