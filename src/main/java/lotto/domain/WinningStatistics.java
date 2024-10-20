package lotto.domain;

import java.util.EnumMap;

public class WinningStatistics {

    private final EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
    private final LotteryMachine lotteryMachine;

    public WinningStatistics(LotteryMachine machine, Lotto winningLotto, LottoNumber bonusNumber) {
        this.lotteryMachine = machine;
        validateBonusNumber(winningLotto, bonusNumber);
        calculateStatistics(machine, winningLotto, bonusNumber);
    }

    private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 우승 로또 번호와 겹칠 수 없습니다.");
        }
    }

    private void calculateStatistics(LotteryMachine machine, Lotto winningLotto, LottoNumber bonusNumber) {
        initialRankStatistics();
        for (Lotto lotto : machine.getLottos()) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean isBonusMatch = lotto.contains(bonusNumber);
            Rank rank = Rank.valueOfMatchCount(matchCount, isBonusMatch);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private void initialRankStatistics() {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public int getRankCount(Rank rank) {
        return rankCounts.get(rank);
    }

    public double calculateProfitRate() {
        int totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / (double) lotteryMachine.getTotalPurchasePrice();
    }
}
