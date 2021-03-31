package lotto.domain;

import lotto.enums.WinningRank;

import java.util.*;

public class RanksCount {
    private static final int INIT = 0;
    private static final int MATCHED_COUNT_MIN = 3;
    private static final int PLUS = 1;
    private final Map<WinningRank, Integer> ranksCount;
    private final WinningNumbers winningNumbers;
    private final LottoTickets lottoTickets;

    public RanksCount(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        this.winningNumbers = winningNumbers;
        this.lottoTickets = lottoTickets;
        this.ranksCount = initialValue();
    }

    public void count() {
        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            MatchedCount matchedCount = winningNumbers.countMatchingNumbers(lottoTicket.lottoNumbers());
            WinningRank rank = WinningRank.findByMacthedCount(matchedCount.matchedCount());
            add(rank);
        }
    }

    public void add(WinningRank rank) {
        if (rank.equals(WinningRank.ETC)) {
            return;
        }

        ranksCount.put(rank, ranksCount.get(rank) + PLUS);
    }

    public void add(List<WinningRank> ranks) {
        for (WinningRank rank : ranks) {
            add(rank);
        }
    }

    public TotalPrize totalPrize() {
        int totalPrize = 0;

        for (Map.Entry<WinningRank, Integer> rank : ranksCount.entrySet()) {
            totalPrize += rank.getKey().prize() * rank.getValue();
        }

        return new TotalPrize(totalPrize);
    }

    public int countOf(WinningRank rank) {
        return ranksCount.get(rank);
    }

    public Map<WinningRank, Integer> ranksCount() {
        return Collections.unmodifiableMap(ranksCount);
    }

    private TreeMap<WinningRank, Integer> initialValue() {
        TreeMap<WinningRank, Integer> ranksCount = new TreeMap<>(Comparator.comparingInt(WinningRank::matchedCount));

        Arrays.stream(WinningRank.values())
                .filter(rank -> rank.matchedCount() >= MATCHED_COUNT_MIN)
                .forEach(rank -> ranksCount.put(rank, INIT));

        return ranksCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RanksCount that = (RanksCount) o;
        return Objects.equals(ranksCount, that.ranksCount) &&
                Objects.equals(winningNumbers, that.winningNumbers) &&
                Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranksCount, winningNumbers, lottoTickets);
    }
}
