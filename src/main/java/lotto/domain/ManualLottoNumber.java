package lotto.domain;

public class ManualLottoNumber {

    private final int number;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    public ManualLottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number){
        if(number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
