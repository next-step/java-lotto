package lotto.domain;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    private List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public long getMatchedNumberCount(NumberMatcher numberMatcher) {
        return numbers.stream().filter(it -> numberMatcher.match(it)).count();
    }

    public void print(PrintWriter writer) {
        writer.print(toString());
    }

    @Override
    public String toString() {
        return String.join(
                ",",
                numbers.stream()
                        .map(String::valueOf)
                        .toArray(CharSequence[]::new));
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
