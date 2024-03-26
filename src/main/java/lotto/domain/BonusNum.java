package lotto.domain;

public class BonusNum {

    private static final int MIN_ELEMENT = 1;
    private static final int MAX_ELEMENT = 45;
    private int value;

    public BonusNum(int bonusNum){
        checkBound(bonusNum);
        this.value = bonusNum;
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
