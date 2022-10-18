package lotto.domain;

import java.util.List;
import java.util.Objects;

import static lotto.util.LottoNumber.getLottoNumberList;

public class Lotto {

    private final List<Integer> numberList;

    public Lotto() {
        this.numberList = getLottoNumberList();
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numberList, lotto.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }
}
