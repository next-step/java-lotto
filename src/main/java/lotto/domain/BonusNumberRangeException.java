package lotto.domain;

public class BonusNumberRangeException extends IllegalArgumentException {
    public BonusNumberRangeException() {
        super("보너스 번호 1~45 사이의 수만 가능합니다.");
    }
}
