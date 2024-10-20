package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber lottoNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber lottoNumber) {
        this.winningLotto = winningLotto;
        this.lottoNumber = lottoNumber;
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
        return userLotto.values().contains(this.lottoNumber);
    }

}
