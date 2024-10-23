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

    public List<LottoDetailMatch> matchLottoNumber(List<Lotto> userLottoList, int bonusNumber) {
        return userLottoList.stream()
                .map(userLotto -> userLotto.countMatches(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> matchAndCount(List<Lotto> userLottoList, int bonusNumber) {
        List<LottoDetailMatch> matchResult = userLottoList.stream()
                .map(userLotto -> userLotto.countMatches(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
        return countMatch(matchResult);
    }
    // 순위에 맞게 몇개 일치하는지 갯수를 센다
    private Map<String, Integer> countMatch(List<LottoDetailMatch> matchedLottoList) {
        Map<String, Integer> rankCounts = initializeRankCounts();

        for (LottoDetailMatch lottoDetailMatch : matchedLottoList) {
            LottoRank lottoRank = LottoRank.findByCount(lottoDetailMatch.getMatchCount(), lottoDetailMatch.isMatchBonus());
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
