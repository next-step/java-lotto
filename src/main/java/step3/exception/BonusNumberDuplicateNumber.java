package step3.exception;

public class BonusNumberDuplicateNumber extends IllegalArgumentException{

    public static final String DUPLICATE_NUMBER = "로또숫자에서 중복된 보너스 숫자입니다.";

    public BonusNumberDuplicateNumber() {
        super(DUPLICATE_NUMBER);
    }
}
