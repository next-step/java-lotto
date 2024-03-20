package lotto;

public class LottoNumber {
    private final static int MINIMUM_NUMBER = 1;
    private final static int MAXIMUM_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validNumberRange(int number) {
        if(number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER){
            throw new IllegalArgumentException("로또 숫자는 1~45 사이 숫자여야 합니다.");
        }
    }
}
