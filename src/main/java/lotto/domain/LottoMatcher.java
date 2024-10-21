package lotto.domain;

import lotto.constants.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatcher {
    private final Lotto winningNumbers;

    public LottoMatcher(LottoGenerator lottoGenerator, String winningNumbers) {
        this.winningNumbers = lottoGenerator.parseWinningNumbers(winningNumbers);
    }

    public List<Integer> matchLottoNumber(List<Lotto> userLottoList) {
        return userLottoList.stream()
                .map(userLotto -> userLotto.countMatches(winningNumbers))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> countMatch(List<Integer> matchedLottoList) {
        Map<String, Integer> rankCounts = initializeRankCounts();

        for (Integer count : matchedLottoList) {
            LottoRank lottoRank = LottoRank.findByCount(count);
            rankCounts.put(lottoRank.getRank(), rankCounts.get(lottoRank.getRank()) + 1);
        }

        return rankCounts;
    }

    private Map<String, Integer> initializeRankCounts() {
        Map<String, Integer> rankCounts = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank.getRank(), 0);
        }
        return rankCounts;
    }

    public double calculateProfitRate(Map<String, Integer> rankCounts, int purchasedAmount) {

        long totalEarnings = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalEarnings += rank.getAmount() * rankCounts.get(rank.getRank());
        }

        return (double) totalEarnings / purchasedAmount;

    }

    @Override
    public String toString() {
        return "LottoMatcher{" +
                "winningNumbers=" + winningNumbers +
                '}';
    }
}
