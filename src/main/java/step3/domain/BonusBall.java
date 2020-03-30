package step3.domain;

public class BonusBall {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private int bonusBall;

    public BonusBall(int inputValue) {
        validateBonusBall(inputValue);
        this.bonusBall = inputValue;
    }

    private void validateBonusBall(int inputValue) {
        if (inputValue > LOTTO_END_NUMBER || inputValue < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException("보너스볼 번호형식이 틀렸습니다.");
        }
    }
}
