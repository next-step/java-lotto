package lotto.domain;

public class BonusNum {

    private static final int MIN_ELEMENT = 1;
    private static final int MAX_ELEMENT = 45;
    private int value;

    public BonusNum(int bonusNum, Lotto lotto){
        checkBound(bonusNum);
        for (int input: lotto.getLottoList()) {
            validBonusNum(input, bonusNum);
        }
            this.value = bonusNum;
    }

    public void validBonusNum(int input, int bonusNum){
        if (input == bonusNum) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복 불가");
        }
    }

    private void checkBound(int input){
        if (input < MIN_ELEMENT || input > MAX_ELEMENT) {
            throw new IllegalArgumentException("로또는 1~45 사이 원소 사용");
        }
    }

    public int getBonusNum() {
        return this.value;
    }
}
