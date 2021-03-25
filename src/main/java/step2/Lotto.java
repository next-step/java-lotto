package step2;

import java.util.Objects;

public class Lotto {
    private LottoNumber number;

    public Lotto(int number){
        this(new LottoNumber(number));
    }

    public Lotto(LottoNumber number){
        this.number = number;
    }

    public LottoNumber lotto(){
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(number, lotto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
