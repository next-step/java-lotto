package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotteries {

    private List<LottoNumbers> lottoNumbers;

    public Lotteries(final List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public int count() {
        return lottoNumbers.size();
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoResult analyzeWin(final LottoNumbers winningLotteNumbers, final BonusBall bonusBall) {
        LottoResult lottoResult = new LottoResult();
        for (LottoNumbers purchase : lottoNumbers) {
            int matchCount = purchase.analyzeMatchCount(winningLotteNumbers);
            boolean hasBonusBall = purchase.hasBonusBall(bonusBall);
            LottoRank lottoRank = LottoRank.findRank(matchCount, hasBonusBall);
            lottoResult.increase(lottoRank);
        }
        return lottoResult;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lotteries lotteries = (Lotteries) o;
        return Objects.equals(lottoNumbers, lotteries.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
