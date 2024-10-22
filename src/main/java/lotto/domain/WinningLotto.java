package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(String[] winningLotto, int bonusLottoNumber) {
        this(new Lotto(winningLotto), new LottoNumber(bonusLottoNumber));
    }

    public WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoRank createLottoRank(Lotto userLotto) {
        return LottoRank.from(this.countLottoNumberMatching(userLotto), this.isBonusBallMatching(userLotto));
    }

    private int countLottoNumberMatching(Lotto userLotto) {
        return (int) userLotto.values().stream()
                .filter(winningLotto.values()::contains)
                .count();
    }

    private Boolean isBonusBallMatching(Lotto userLotto) {
        return userLotto.values().contains(this.bonusLottoNumber);
    }

}
