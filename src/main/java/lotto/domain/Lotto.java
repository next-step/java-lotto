package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumbers> lottoNumbers;

    public Lotto(Lotto... lottos) {
        this(combineLottoNumbers(lottos));
    }

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoResult getMatchResult(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();

        for (LottoNumbers lottoNumbers : lottoNumbers) {
            LottoRank rank = winningLotto.getMatchedRank(lottoNumbers);
            result.add(rank);
        }

        return result;
    }

    private static List<LottoNumbers> combineLottoNumbers(Lotto... lottos) {
        List<LottoNumbers> combined = new ArrayList<>();
        for (Lotto lotto : lottos) {
            combined.addAll(lotto.lottoNumbers);
        }

        return combined;
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().map(LottoNumbers::toString).collect(Collectors.joining("\n"));
    }
}
