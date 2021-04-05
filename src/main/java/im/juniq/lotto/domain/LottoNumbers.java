package im.juniq.lotto.domain;

import java.util.Iterator;
import java.util.List;

public class LottoNumbers implements Iterable<Integer> {
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개 이어야 합니다.");
        }
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
