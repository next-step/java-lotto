package lotto;

import java.util.Objects;
import java.util.Random;

public class Lotto {
    private static final int CORRECT_VALUE = 1;
    private Integer number;

    public Lotto() {
        this(null);
    }

    public Lotto(Integer number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void selectLottoNumber() {
        this.number = getRandomNumber();
    }

    private int getRandomNumber() {
        int number = new Random().nextInt(44);
        return number + CORRECT_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return number == lotto.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
