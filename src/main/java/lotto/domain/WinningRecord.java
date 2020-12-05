package lotto.domain;

public class WinningRecord {

    private final Lotto winningLotto;

    private final WinningCount winningCount;

    public WinningRecord(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        this.winningCount = new WinningCount();
    }

    public void record(Lottoes lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            int matchCount = countMatchingNumbers(lotto);
            winningCount.increaseCount(matchCount);
        }
    }

    private int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }

    public int getMatchCount(int matchCount) {
        return winningCount.getMatchCount(matchCount);
    }

    public int calculatePrize() {
        return winningCount.calculatePrize();
    }

    public double calculateEarnRate(int paid) {
        int totalPrize = calculatePrize();
        return (double) totalPrize / paid;
    }
}
