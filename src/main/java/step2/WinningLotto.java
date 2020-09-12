package step2;

public class WinningLotto {

    private final Lotto winningLotto;

    private WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static WinningLotto create(int... nums) {
        return new WinningLotto(Lotto.create(nums));
    }

    public Rank match(Lotto lotto) {
        int matchCount = 0;

        for (LottoNumber lottoNumber : lotto) {
            if (winningLotto.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return Rank.getRank(matchCount);
    }
}
