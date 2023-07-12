package lottogame.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoResult {

    private final LottoTicket lottoTicket;
    private final LottoBonus lottoBonus;

    public LottoResult(Set<Integer> lottoNumbers, int bonusNumber) {
        this.lottoTicket = new LottoTicket(lottoNumbers);
        this.lottoBonus = new LottoBonus(bonusNumber, this.lottoTicket);
    }

    public List<LottoPrize> toLottoPrizes(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
            .map(this::toLottoPrize)
            .collect(Collectors.toList());
    }

    private LottoPrize toLottoPrize(LottoTicket lottoTicket) {
        return LottoPrize.of(this.lottoTicket.getMatchedCount(lottoTicket), lottoBonus.isContained(lottoTicket));
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
