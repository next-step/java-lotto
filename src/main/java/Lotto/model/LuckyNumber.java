package Lotto.model;

public class LuckyNumber {

    private static final String LUCKY_NUMBER_CONSTRUCTOR_ERROR = "중복된 로또번호는 불가능합니다.";
    private static final int SECOND_MATCH_COUNT = 5;

    private Lotto luckyNumber;
    private LottoNumber bonusNumber;

    public LuckyNumber(Lotto luckyNumber, LottoNumber bonusNumber) {
        validate(luckyNumber, bonusNumber);
        this.luckyNumber = luckyNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto luckyNumber, LottoNumber bonusNumber) {
        if (luckyNumber.isContain(bonusNumber)) {
            throw new IllegalArgumentException(LUCKY_NUMBER_CONSTRUCTOR_ERROR);
        }
    }

    public int countMatchNumbers(Lotto lotto) {
        return lotto.countMatchNumbers(luckyNumber);
    }

    public boolean isSecondAble(Lotto lotto, int matchCount) {
        return matchCount == SECOND_MATCH_COUNT && lotto.isContain(bonusNumber);
    }
}
