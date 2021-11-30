package lotto.domain;

public class LottoNum {

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    private int number;

    public LottoNum(int number) {
        validateLottoNum(number);
        this.number = number;
    }

    private void validateLottoNum(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("Number should be in 1 to 45");
        }
    }

}
