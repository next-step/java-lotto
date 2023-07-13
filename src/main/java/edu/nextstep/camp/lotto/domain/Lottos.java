package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoAnalysisResult analysis(LastWinLotto lastWinLotto) {
        List<LottoRank> lottoRankList = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottoRankList.add(lastWinLotto.checkRank(lotto));
        }

        return new LottoAnalysisResult(lottoRankList);
    }

    /**
     * @Deprecated 보너스 번호 추가로 미사용
     */
    @Deprecated
    public LottoAnalysisResult analysis(Integer... beforeLottoNums) {
        return this.analysis(new Lotto(beforeLottoNums));
    }

    /**
     * @Deprecated 보너스 번호 추가로 미사용
     */
    @Deprecated
    LottoAnalysisResult analysis(Lotto beforeLotto) {
        List<LottoRank> lottoRankList = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottoRankList.add(LottoRank.valueOf(lotto.matchNumberCount(beforeLotto)));
        }

        return new LottoAnalysisResult(lottoRankList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
