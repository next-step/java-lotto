package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchPointRank;

import java.util.List;

public class LottoService {

    private final List<Lotto> lottoList;
    private MatchPointRank matchPointRank;

    public LottoService(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        matchPointRank = null;
    }

    public void playLotto(String[] winningNum) {
        this.compareWinningNumber(winningNum);
        this.matchPointRank = new MatchPointRank();

        for (Lotto lotto : lottoList) {
            matchPointRank.compareMatchPoint(lotto);
        }
    }

    private void compareWinningNumber(String[] winningNum) {
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
