package lotto.domain.lotto;

public class BonusNumberDuplicateException extends IllegalArgumentException {
    public BonusNumberDuplicateException() {
        super("보너스 번호는 당첨번호와 중복될 수 없습니다.");
    }
}
