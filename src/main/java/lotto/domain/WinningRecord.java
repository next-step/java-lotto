package lotto.domain;

public class WinningRecord {

    private final Lotto winningLotto;

    public WinningRecord(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningCount record(Lottoes lottoes) {
        WinningCount winningCount = new WinningCount();

        for (Lotto lotto : lottoes.getLottoes()) {
            int matchCount = countMatchingNumbers(lotto);
            winningCount.increaseCount(matchCount);
        }

        return winningCount;
    }

    private int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }
}
