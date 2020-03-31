package lotto.domain.item;

import lotto.exception.ValidLottoException;

import java.util.*;

public class Lotto implements Item {

    protected final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if (numbers == null) {
            numbers = new ArrayList<>();
        }
        Collections.sort(numbers);

        List<LottoNumber> result = new ArrayList<>(numbers);
        this.numbers = Collections.unmodifiableList(result);
    }

    @Override
    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
