package lotto.domain;

public class LottoNumber {

    private final static int LOTTO_BOUND_MAX_NUMBER = 45;
    private final static int LOTTO_BOUND_MIN_NUMBER = 1;

    private final int number;

    public LottoNumber(int number){
        if (number > LOTTO_BOUND_MAX_NUMBER || number < LOTTO_BOUND_MIN_NUMBER) {
            throw new IllegalArgumentException("로또 번호의 범위를 벗어났습니다." + number);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
