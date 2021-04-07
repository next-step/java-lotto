package lotto.domain;

import lotto.domain.Dto.RankCountDto;
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

    public void count(BonusBall bonusBall) {
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
                .map(Prize::new)
                .collect(Collectors.toList());

        return new TotalPrize(totalPrize);
    }

    public int countOf(WinningRank rank) {
        return ranksCount.get(rank);
    }

    public List<RankCountDto> dtos() {
        List<RankCountDto> rankCountDtos = new ArrayList<>();

        for (Map.Entry<WinningRank, Integer> rank : ranksCount.entrySet()) {
            RankCountDto rankCountDto = new RankCountDto(rank.getKey().matchedCount().matchedCount(), rank.getKey().hasBonus(), rank.getKey().prize().prize(), rank.getValue());
            rankCountDtos.add(rankCountDto);
        }

        return rankCountDtos;
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
