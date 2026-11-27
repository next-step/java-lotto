package domain;

public class WinningLotto {

    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningLotto(int bonusNumber, int... winningNumber) {
        this(new Lotto(winningNumber), new LottoNumber(bonusNumber));
    }

    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호는 중복이 불가능합니다.");
        }
    }

    public Rank match(Lotto lotto) {
        MatchCount matchCount = winningNumber.match(lotto);
        boolean bonusMatched = lotto.contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatched);
    }

}
