package im.juniq.lotto.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers implements Iterable<LottoNumber> {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 " + LOTTO_NUMBERS_SIZE + "개 이어야 합니다.");
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 중복 될 수 없습니다.");
        }
        this.numbers = numbers.stream().sorted().map(LottoNumber::new).collect(Collectors.toList());
    }

    public LottoNumbers(String numbers) {
        this(Arrays.stream(numbers.split(",")).map(Integer::valueOf).collect(Collectors.toList()));
    }

    public int matchedCount(LottoNumbers lottoNumbers) {
        return (int) numbers.stream().filter(lottoNumbers::contain).count();
    }

    public boolean contain(LottoNumber number) {
        return numbers.contains(number);
    }

    public int size() {
        return numbers.size();
    }

    public LottoNumber get(int index) {
        return numbers.get(index);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return numbers.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumbers)) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
