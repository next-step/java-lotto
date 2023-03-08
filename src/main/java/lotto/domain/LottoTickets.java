package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.ui.LottoResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets of(int count) {
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tickets.add(LottoTicket.create());
        }

        return new LottoTickets(tickets);
    }

    public int size() {
        return tickets.size();
    }

    public LottoResult findWinningStatistics(List<Integer> numbers, int bonusNumber) {

        Map<LottoRank, Integer> ranks = new HashMap<>();

        tickets.forEach(ticket -> {
            LottoRank rank = ticket.getHitCount(numbers, bonusNumber);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        });

        ranks.remove(null);

        printWinningStatistics(ranks);

        return new LottoResult(ranks);
    }

    private void printWinningStatistics(Map<LottoRank, Integer> ranks) {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(LottoRank.values())
                .forEach(rank -> {
                    String result = createResult(ranks, rank);
                    sb.append(result).append("\n");
                });

        BigDecimal totalRate = calcTotalRate(ranks);
        sb.append("총 수익률은 ").append(calcTotalRate(ranks)).append("% 입니다.").append("\n");
        System.out.println(sb);
    }

    private String createResult(Map<LottoRank, Integer> ranks, LottoRank rank) {
        Integer integer = ranks.get(rank);
        int count = 0;
        if (integer != null) {
            count = integer;
        }
        return String.format("%s- %d개", rank, count);
    }

    public BigDecimal calcTotalRate(Map<LottoRank, Integer> ranks) {
        BigDecimal buyingPrice = new BigDecimal(size() * LOTTO_PRICE);
        int sum = 0;

        Set<LottoRank> lottoRanks = ranks.keySet();

        for (LottoRank lottoRank : lottoRanks) {
            int hitCount = ranks.get(lottoRank);
            int rewarding = lottoRank.getRewarding();
            sum += rewarding * hitCount;
        }

        BigDecimal totalRewarding = new BigDecimal(sum);
        return totalRewarding.divide(buyingPrice, 2, RoundingMode.DOWN);
    }
}
