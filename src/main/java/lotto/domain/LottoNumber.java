package lotto.domain;

public class LottoNumber {
    private final int number;

    public LottoNumber(Integer number) {
        if(number == null) {
            throw new NullPointerException();
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
