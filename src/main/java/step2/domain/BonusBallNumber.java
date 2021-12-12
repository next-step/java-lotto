package step2.domain;

import step2.exception.UniqueBonusBallException;

public class BonusBallNumber {
    private final LottoNumber bonusBallNumber;

    public BonusBallNumber(int bonusBallNumber) {
        this.bonusBallNumber = new LottoNumber(bonusBallNumber);
    }

    public LottoNumber getBonusBallNumber() {
        return bonusBallNumber;
    }

    public void notUniqueOrElseThrow(MatchedNumber matchedNumber) {
        if (matchedNumber.getMatchedNumbers().contains(bonusBallNumber)) {
            throw new UniqueBonusBallException();
        }
    }
}
