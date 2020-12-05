package lotto.domain;

public final class WinningRecord {

    private final Lotto winningLotto;

    private final LottoNumber bonusBall;

    public WinningRecord(Lotto winningLotto, int bonusBall) {
        this(winningLotto, new LottoNumber(bonusBall));
    }

    public WinningRecord(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public WinningCount record(final Lottoes lottoes) {
        final WinningCount winningCount = new WinningCount();

        for (Lotto lotto : lottoes.getLottoes()) {
            int matchCount = winningLotto.countContainNumbers(lotto);
            boolean matchBonus = lotto.contains(bonusBall);
            Rank rank = Rank.valueOf(matchCount, matchBonus);

            winningCount.increaseCount(rank);
        }

        return winningCount;
    }
}
