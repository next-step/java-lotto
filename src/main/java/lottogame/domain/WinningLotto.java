package lottogame.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {

    private final LottoTicket lottoTicket;
    private final LottoBonus lottoBonus;

    public WinningLotto(Set<Integer> lottoNumbers, int bonusNumber) {
        this.lottoTicket = new LottoTicket(lottoNumbers);
        this.lottoBonus = new LottoBonus(bonusNumber, this.lottoTicket);
    }

    public List<LottoRank> toLottoRanks(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
            .map(this::toLottoRank)
            .collect(Collectors.toList());
    }

    private LottoRank toLottoRank(LottoTicket lottoTicket) {
        return LottoRank.of(this.lottoTicket.getMatchedCount(lottoTicket), lottoBonus.isContained(lottoTicket));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningLotto)) {
            return false;
        }
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lottoTicket, that.lottoTicket) && Objects.equals(lottoBonus,
            that.lottoBonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket, lottoBonus);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lottoTicket=" + lottoTicket +
                ", lottoBonus=" + lottoBonus +
                '}';
    }
}
