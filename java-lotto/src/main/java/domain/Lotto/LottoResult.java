package domain.Lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static final Map<Integer, Integer> PRIZE_MONEY = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );

    private final Map<Rank, Integer> matchCounts;

    public LottoResult(Map<Rank, Integer> matchCounts) {
        this.matchCounts = new EnumMap<>(matchCounts); // 복사할 때도 EnumMap 사용
    }

    public static LottoResult from(List<LottoTicket> tickets, WinningLotto winningLotto) {
        Map<Rank, Integer> matchCounts = new EnumMap<>(Rank.class);

        for (LottoTicket ticket : tickets) {
            int matchCount = winningLotto.matchCountWith(ticket);
            boolean matchBonus = winningLotto.hasBonus(ticket);

            Rank rank = Rank.valueOf(matchCount, matchBonus);
            matchCounts.put(rank, matchCounts.getOrDefault(rank, 0) + 1);
        }

        return new LottoResult(matchCounts);
    }

    public double calculateProfitRate(int totalSpent) {
        int totalPrize = matchCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
        if (totalSpent == 0) {
            return 0.0; // 나눗셈 예외 방지
        }
        return (double) totalPrize / totalSpent;
    }
    /**
     * 당첨 개수별 로또 개수를 반환합니다.
     *
     * @return Map<Integer, Integer> 형식의 값으로,
     *         - key: 당첨 번호 개수 (예: 3, 4, 5, 6)
     *         - value: 해당 개수만큼 맞춘 로또 티켓의 수
     */
    public Map<Rank, Integer> getMatchCounts() {
        return matchCounts;
    }
}
