package lotto.domain;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {

    private List<Integer> numbers;
    private LottoNumberParser lottoNumberParser = new LottoNumberParser();

    public LottoNumber(String numberString){
        parse(numberString);
    }

    private void parse(String numberString) {
        this.numbers = lottoNumberParser.parse(numberString);
    }

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
        return Objects.equals(
                this.numbers.stream().sorted().collect(Collectors.toList()),
                that.numbers.stream().sorted().collect(Collectors.toList()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numbers);
    }

}
