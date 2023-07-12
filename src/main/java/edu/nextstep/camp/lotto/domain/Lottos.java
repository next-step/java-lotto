package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoAnalysisResult analysis(Integer... beforeLottoNums){
        return this.analysis(new Lotto(beforeLottoNums));
    }

    LottoAnalysisResult analysis(Lotto beforeLotto) {
        List<LottoRank> lottoRankList = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottoRankList.add(LottoRank.withMatchNumberCount(lotto.matchNumberCount(beforeLotto)));
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
