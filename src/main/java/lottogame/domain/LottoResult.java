package lottogame.domain;

import java.util.Objects;
import java.util.Set;

public class LottoResult {

    private final LottoTicket lottoTicket;
    private final LottoBonus lottoBonus;

    public LottoResult(Set<Integer> lottoNumbers, int bonusNumber) {
        this.lottoTicket = new LottoTicket(lottoNumbers);
        this.lottoBonus = new LottoBonus(bonusNumber, this.lottoTicket);
    }

    public LottoPrize checkLottoTicket(LottoTicket lottoTicket) {
        return LottoPrize.from(this.lottoTicket.getMatchedCount(lottoTicket), lottoBonus.isContained(lottoTicket));
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
        return Objects.equals(lottoTicket, that.lottoTicket) && Objects.equals(lottoBonus,
            that.lottoBonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket, lottoBonus);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
            "lottoNumbers=" + lottoTicket +
            ", lottoBonus=" + lottoBonus +
            '}';
    }
}
