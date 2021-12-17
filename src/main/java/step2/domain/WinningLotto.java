package step2.domain;

import step2.exception.UniqueBonusBallException;

public class WinningLotto {

    private final MatchedNumber matchedNumber;
    private final LottoNumber bonusBallNumber;

    public WinningLotto(MatchedNumber matchedNumber, int bonusBallNumber) {
        this.matchedNumber = matchedNumber;
        this.bonusBallNumber = new LottoNumber(bonusBallNumber);

        notUniqueOrElseThrow();
    }

    public MatchedNumber getMatchedNumber() {
        return matchedNumber;
    }

    public LottoNumber getBonusBallNumber() {
        return bonusBallNumber;
    }

    private void notUniqueOrElseThrow() {
        if (this.matchedNumber.matchedNumber(bonusBallNumber)) {
            throw new UniqueBonusBallException();
        }
    }
}
