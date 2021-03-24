package step2;

import java.util.Objects;

public class Lotto {
    private int number;

    public Lotto(int number){
        this.number = number;
    }

    public Lotto(LottoNumberGenerator generator){
        this.number = generator.generator();
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
