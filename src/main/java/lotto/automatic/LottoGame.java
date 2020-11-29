package lotto.automatic;

import lotto.automatic.domain.*;

import java.util.List;

public class LottoGame {

    private final LottoGenerator generator;

    public LottoGame() {

        generator = new LottoGenerator(new RandomShuffle());
    }

    public List<Lotto> generateLotto(int lottoAmount) {
        return generator.generateLotto(lottoAmount);
    }

    public LottoResult getLottoResult(int investMoney, List<LottoRank> rankList) {

        return new LottoResult(investMoney, rankList);
    }

    public List<LottoRank> getLottoRank(List<Lotto> lottoList, List<LottoNumber> lottoNumbers) {
        Lotto winningLotto = new Lotto(lottoNumbers);

        LottoRankCollector collector = new LottoRankCollector(lottoList, winningLotto);

        return collector.getRankList();
    }
}
