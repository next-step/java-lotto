package lotto.domain.value;

import java.util.*;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public static LottoTickets of(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getDetailTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public Map<Rank, Integer> creatWinningRank(WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        lottoTickets.forEach(
                lottoTicket -> {
                    int matchCount = lottoTicket.countMatchWinningNumber(winningNumbers.getNumbers());
                    result.put(Rank.matchRankOf(matchCount), matchCount);
                });

        return result;
    }
}
