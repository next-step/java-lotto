package lotto.domain;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {

    private List<LottoNumber> numbers;
    private LottoNumbersParser lottoNumbersParser = new LottoNumbersParser();

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public LottoNumbers(String numberString){
        parse(numberString);
    }

    private void parse(String numberString) {
        this.numbers = lottoNumbersParser.parse(numberString);
    }


    public long getMatchedNumberCount(LottoNumberMatcher lottoNumberMatcher) {
        return numbers.stream().filter(it -> lottoNumberMatcher.match(it)).count();
    }

    public void print(PrintWriter writer) {
        writer.print(toString());
    }

    @Override
    public String toString() {
        return numbers.stream().map(LottoNumber::toString).collect(Collectors.joining(","));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(
                this.numbers.stream().sorted().collect(Collectors.toList()),
                that.numbers.stream().sorted().collect(Collectors.toList()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numbers);
    }

}
