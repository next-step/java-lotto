package lotto.domain;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {

    private List<LottoNumber> numbers;
    private LottoNumbersParser lottoNumbersParser = new LottoNumbersParser();

    public LottoNumbers(List<LottoNumber> numbers) {
        shouldNotDuplicate(numbers);
        this.numbers = numbers;
    }

    public LottoNumbers(String numberString){
        List<LottoNumber> numbers = parse(numberString);
        shouldNotDuplicate(numbers);
        this.numbers = numbers;
    }

    private void shouldNotDuplicate(List<LottoNumber> numbers) {
        if( numbers.stream()
                .collect(Collectors.toMap(
                        it -> it.getValue(),
                        it -> 1,
                        (current, plus) -> current + plus)).keySet().size() < numbers.size() ){
            throw new LottoNumbersException("로또번호에 중복된 번호가 포함되어 있습니다");
        }
    }

    private List<LottoNumber> parse(String numberString) {
        return lottoNumbersParser.parse(numberString);
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
