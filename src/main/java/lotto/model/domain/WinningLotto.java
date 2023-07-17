package lotto.model.domain;


public final class WinningLotto {

    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    private WinningLotto(final Lotto winningNumbers, final LottoNumber bonusBall) {
        validate(winningNumbers, bonusBall);

        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(final Lotto winningNumbers, final LottoNumber bonusBall) {
        return new WinningLotto(winningNumbers, bonusBall);
    }

    private void validate(final Lotto numbers, final LottoNumber bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼은 중복될 수 없습니다.");
        }
    }

    public Rank checkRank(Lotto lotto) {
        final int matchCount = lotto.checkMatchCount(winningNumbers);
        final boolean hasBonusBall = lotto.contains(bonusBall);
        return Rank.valueOf(matchCount, hasBonusBall);
    }
}
