package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumbers> lottoNumbers;
    private final LottoCount totalCount;
    private final LottoCount manualCount;

    public Lotto(LottoCount totalCount, LottoCount manualCount, List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.totalCount = totalCount;
        this.manualCount = manualCount;
    }

    public LottoResult getMatchResult(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();

        for (LottoNumbers lottoNumbers : lottoNumbers) {
            LottoRank rank = winningLotto.getMatchedRank(lottoNumbers);
            result.add(rank);
        }

        return result;
    }

    public String toCountString() {
        return String.format("수동으로 %s장, 자동으로 %s장을 구매했습니다.", manualCount.toString(), totalCount.diff(manualCount).toString());
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().map(LottoNumbers::toString).collect(Collectors.joining("\n"));
    }
}
