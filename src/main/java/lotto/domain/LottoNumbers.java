package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {

     static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> orderedNumbers;

    public LottoNumbers(List<Integer> numbers) {
        List<Integer> lottoNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 중복 없는 6 자리 숫자 입니다.");
        }

        this.orderedNumbers = Collections.unmodifiableList(
                lottoNumbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public static LottoNumbers valueOf(List<Integer> numbers){
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers valueOf(String[] numbers){
        return new LottoNumbers(Stream.of(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public static LottoNumbers valueOf(Integer... numbers) { return new LottoNumbers(Arrays.asList(numbers)); }

    public int match(LottoNumbers other) {
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.addAll(orderedNumbers);
        numbers.addAll(other.getOrderedNumbers());
        return LOTTO_SIZE + LOTTO_SIZE - numbers.size();
    }

    public List<LottoNumber> getOrderedNumbers() {
        return orderedNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(orderedNumbers, that.orderedNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedNumbers);
    }

}
