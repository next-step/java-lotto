package lotto.domain.value;

import java.util.*;

public class LottoTickets {
    private static final int INIT_COUNT = 0;
    private static final int INCREASE_NUMBER = 1;

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
        Map<Rank, Integer> result = createInitialMap();

        lottoTickets.forEach(
                lottoTicket -> {
                    int matchCount = lottoTicket.countMatchWinningNumber(winningNumbers.getNumbers());
                    result.put(
                            Rank.matchRankOf(matchCount),
                            result.getOrDefault(Rank.matchRankOf(matchCount), INIT_COUNT) + INCREASE_NUMBER);
                });

        return result;
    }

    private Map<Rank, Integer> createInitialMap() {
        Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);

        Arrays.stream(Rank.values())
                .forEach(rank -> rankMap.put(rank, INIT_COUNT));

        return rankMap;
    }
}
