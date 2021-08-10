package lotto.model;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers implements Iterable<LottoNumber> {
    private List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public int size() {
        return numbers.size();
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return numbers.iterator();
    }

    public Stream<LottoNumber> stream() {
        return numbers.stream();
    }
}
