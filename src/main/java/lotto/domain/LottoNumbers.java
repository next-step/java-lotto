package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers(int startInclusive, int endInclusive) {
        this(IntStream.range(startInclusive, endInclusive+1)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public LottoNumbers shuffle() {
        LottoNumbers lottoNumbers = new LottoNumbers(this.numbers);
        Collections.shuffle(lottoNumbers.numbers);
        return lottoNumbers;
    }

    public LottoNumbers take(int n){
        return new LottoNumbers(this.numbers.stream()
                .limit(n).collect(Collectors.toList()));
    }

    public LottoNumbers sort() {
        LottoNumbers lottoNumbers = new LottoNumbers(this.numbers);
        Collections.sort(lottoNumbers.numbers);
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int size() {
        return numbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}