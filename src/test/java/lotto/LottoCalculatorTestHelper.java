package lotto;

import lotto.domain.Lotto;
import lotto.type.RankType;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculatorTestHelper {
    private Lotto noRankLotto;
    private Lotto rank1Lotto;
    private Lotto rank2Lotto;
    private Lotto rank3Lotto;
    private Lotto rank4Lotto;
    private Lotto rank5Lotto;

    public LottoCalculatorTestHelper(Lotto noRankLotto, Lotto rank1Lotto, Lotto rank2Lotto, Lotto rank3Lotto, Lotto rank4Lotto, Lotto rank5Lotto) {
        this.noRankLotto = noRankLotto;
        this.rank1Lotto = rank1Lotto;
        this.rank2Lotto = rank2Lotto;
        this.rank3Lotto = rank3Lotto;
        this.rank4Lotto = rank4Lotto;
        this.rank5Lotto = rank5Lotto;
    }

    public List<Lotto> getRankLotto(RankType type, int addCount) {
        List<Lotto> lottoList = new ArrayList<>();

        Lotto lotto = noRankLotto;

        if (type == RankType.RANK1) {
            lotto = rank1Lotto;
        }

        if (type == RankType.RANK2) {
            lotto = rank2Lotto;
        }

        if (type == RankType.RANK3) {
            lotto = rank3Lotto;
        }

        if (type == RankType.RANK4) {
            lotto = rank4Lotto;
        }

        if (type == RankType.RANK5) {
            lotto = rank5Lotto;
        }

        for (int i = 0; i < addCount; i++) {
            lottoList.add(lotto);
        }

        return lottoList;
    }
}
