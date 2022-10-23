package lotto.backend.domain;

import java.util.Arrays;
import java.util.EnumMap;

public class LottoStatistics {

    private final EnumMap<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
    private final int orderAmount;

    public LottoStatistics(LottoTicket winningLotto, LottoTickets lottoTickets) {
        initialize();
        this.orderAmount = lottoTickets.orderAmount();
        for (LottoTicket lottoTicket : lottoTickets.getValues()) {
            int match = lottoTicket.countMatch(winningLotto);
            LottoRank rank = LottoRank.of(match);
            statistics.put(rank, statistics.get(rank) + 1);
        }
    }

    private void initialize() {
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> statistics.put(lottoRank, 0));
    }

    public int printMatch(int match) {
        return statistics.get(LottoRank.of(match));
    }

    public int printPrize(int match) {
        return (int) LottoRank.of(match).getPrize();
    }

    public double printProfit() {
        return prizeAmount() / orderAmount;
    }

    private double prizeAmount() {
        return statistics.entrySet().stream()
                .mapToDouble(i -> i.getKey().getPrize() * i.getValue())
                .sum();
    }
}
