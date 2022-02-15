package lotto.domain;

import static lotto.util.Constant.DIVIDE_UNIT;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoStatistic {

    private final Map<LottoRank, Integer> lottoRankStatistic;

    private LottoStatistic(Map<LottoRank, Integer> lottoRankStatistic) {
        this.lottoRankStatistic = lottoRankStatistic;
    }

    public static LottoStatistic createWinningResult(List<LottoTicket> lottoTickets,
        WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> lottoRankMap = new EnumMap<>(LottoRank.class);
        lottoTickets.forEach(ticket -> {
            LottoRank rank = winningNumbers.getRankForLottoTicket(ticket);
            if (rank != null) {
                lottoRankMap.put(rank, lottoRankMap.getOrDefault(rank, 0) + 1);
            }
        });
        return new LottoStatistic(lottoRankMap);
    }

    public double getProfit(long principal) {
        long total = 0;
        for (Map.Entry<LottoRank, Integer> element : lottoRankStatistic.entrySet()) {
            total += (long) element.getKey().getWinningAmount() * element.getValue();
        }

        return Math.floor(DIVIDE_UNIT * total / principal) / DIVIDE_UNIT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Stream.of(LottoRank.values())
            .forEach(rank -> {
                    int rankValue = 0;
                    if (lottoRankStatistic.containsKey(rank)) {
                        rankValue = lottoRankStatistic.get(rank);
                    }
                    sb.append(rank.getRankString())
                        .append(" (")
                        .append(rank.getWinningAmount())
                        .append(") - ")
                        .append(rankValue)
                        .append("개")
                        .append("\n");
                }
            );
        return sb.toString();
    }

}
