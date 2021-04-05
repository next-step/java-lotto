package im.juniq.lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers implements Iterable<Integer> {
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchedCount(LottoNumbers lottoNumbers) {
        return (int) numbers.stream().filter(lottoNumbers::contain).count();
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }

    public int size() {
        return numbers.size();
    }

    public int get(int index) {
        return numbers.get(index);
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
