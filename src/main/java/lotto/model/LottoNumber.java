package lotto.model;

import java.util.Random;

public class LottoNumber {

    int number;

    public LottoNumber() {
        this.number = new Random().nextInt(45);
    }

    public int getNumber() {
        return number;
    }

    public void validate() throws IllegalAccessException {
        if (number <= 0 || number > 45) {
            throw new IllegalAccessException();
        }
    }
}
