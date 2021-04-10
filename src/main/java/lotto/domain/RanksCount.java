package lotto.domain;

import lotto.enums.WinningRank;

import java.util.*;
import java.util.stream.Collectors;

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

    public void matchWith(BonusBall bonusBall) {
        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            MatchedCount matchedCount = winningNumbers.matchedCountWith(lottoTicket.lottoNumbers());
            boolean matchBonus = lottoTicket.hasBonusNumber(bonusBall);
            WinningRank rank = WinningRank.findByMacthedCount(matchedCount, matchBonus);
            add(rank);
        }
    }

    public void add(WinningRank rank) {
        if (rank.equals(WinningRank.ETC)) {
            return;
        }

        ranksCount.put(rank, ranksCount.get(rank) + PLUS);
    }

    public TotalPrize totalPrize() {
        List<Prize> totalPrize = ranksCount.entrySet()
                .stream()
                .map(rank -> rank.getKey().multiply(rank.getValue()))
                .map(Prize::new)
                .collect(Collectors.toList());

        return new TotalPrize(totalPrize);
    }

    public int countOf(WinningRank rank) {
        return ranksCount.get(rank);
    }

    public Iterable<? extends Map.Entry<WinningRank, Integer>> entrySet() {
        return ranksCount.entrySet();
    }

    private TreeMap<WinningRank, Integer> initialValue() {
        TreeMap<WinningRank, Integer> ranksCount = new TreeMap<>(Comparator.comparing(WinningRank::matchedCount)
                .thenComparing(WinningRank::prize));

        Arrays.stream(WinningRank.values())
                .filter(rank -> rank.matchedCount().isGreaterOrEqualThan(MATCHED_COUNT_MIN))
                .forEach(rank -> ranksCount.put(rank, INIT));

        return ranksCount;
    }
}
