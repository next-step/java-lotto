package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class LottoResult {

    private final List<LottoRank> lottoRanks;

    public LottoResult(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public static LottoResult createLottoResult(WinningNumbers winningTicket, LottoTickets purchaseTickets) {
        return new LottoResult(purchaseTickets.getTickets().stream()
            .map(winningTicket::getLottoRank)
            .collect(Collectors.toList()));
    }

    public Map<LottoRank, Long> getLottoRankCount() {
        return lottoRanks.stream()
            .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public int calculateTotalPrizeMoney() {
        return lottoRanks.stream()
            .mapToInt(rank -> rank.getPrizeMoney(1))
            .reduce(0, Integer::sum)
            ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return lottoRanks.containsAll(that.lottoRanks) && that.lottoRanks.containsAll(lottoRanks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRanks);
    }
}
