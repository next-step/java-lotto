package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumber {

    private List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getMatchedNumberCount(NumberMatcher numberMatcher){
        return (int) numbers.stream().filter(it -> numberMatcher.match(it)).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(this.numbers.stream().sorted(), that.numbers.stream().sorted());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numbers);
    }

}
