package lottogame.domain;

import java.util.Objects;
import java.util.Set;
import lottogame.domain.response.LottoCheckResponse;

public class LottoResult {

    private final LottoNumbers lottoNumbers;
    private final LottoBonus lottoBonus;

    public LottoResult(Set<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
        this.lottoBonus = new LottoBonus(bonusNumber, this.lottoNumbers);
    }

    public LottoCheckResponse checkLottoTicket(LottoNumbers lottoNumbers) {
        return new LottoCheckResponse(this.lottoNumbers.getMatchedCount(lottoNumbers),
            lottoBonus.isContained(lottoNumbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoResult)) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && Objects.equals(lottoBonus,
            that.lottoBonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, lottoBonus);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
            "lottoNumbers=" + lottoNumbers +
            ", lottoBonus=" + lottoBonus +
            '}';
    }
}
