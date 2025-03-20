package lotto.model;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public Integer getLottoNumber(int index) {
        return numbers.get(index);
    }

    public int getMatchCount(Lotto lotto) {
        return (int) IntStream.range(0, this.numbers.size())
                .filter(i -> lotto.getLottoNumber(i).equals(this.numbers.get(i)))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}
