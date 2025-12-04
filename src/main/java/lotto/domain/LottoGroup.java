package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(LottoGenerator lottoGenerator) {
        this(lottoGenerator.generate());
    }

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoNumbers() {
        return lottos;
    }

    public LottoResult match(LottoWinningNumbers winLottoWinningNumbers) {
        return calculate(winLottoWinningNumbers);
    }

    private LottoResult calculate(LottoWinningNumbers winLottoWinningNumbers) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : this.lottos) {
            LottoRank rank = winLottoWinningNumbers.determineRank(lotto);

            lottoResult.rank(rank);
        }

        return lottoResult;
    }
}
