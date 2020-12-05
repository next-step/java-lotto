package lotto.domain;

public final class WinningRecord {

    private final Lotto winningLotto;

    public WinningRecord(final Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningCount record(final Lottoes lottoes) {
        final WinningCount winningCount = new WinningCount();

        for (Lotto lotto : lottoes.getLottoes()) {
            int matchCount = countMatchingNumbers(lotto);
            winningCount.increaseCount(matchCount);
        }

        return winningCount;
    }

    private int countMatchingNumbers(final Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }
}
