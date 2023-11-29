package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoNumbers {
    public static final int COUNT = 6;

    private static final List<LottoNumber> SUFFLED_LOTTO_NUMBER_LIST =
            IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                    .boxed()
                    .map(LottoNumber::Of)
                    .collect(Collectors.toList());

    private final Set<LottoNumber> numbers;

    // 랜덤 생성
    public LottoNumbers() {
        Collections.shuffle(SUFFLED_LOTTO_NUMBER_LIST);
        this.numbers = new TreeSet<>(SUFFLED_LOTTO_NUMBER_LIST.subList(0, COUNT));
    }

    // 수동 생성
    public LottoNumbers(List<Integer> numbers) {
        this.validateCount(numbers);
        this.numbers = numbers
                .stream()
                .map(LottoNumber::Of)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public long matchedNumberCount(LottoNumbers targetLottoNumbers) {
        return this.numbers
                .stream()
                .filter(targetLottoNumbers::isNumberMatched)
                .count();
    }

    public boolean isNumberMatched(LottoNumber lottoNumber) {
        return this.numbers
                .stream()
                .anyMatch(target -> target.compareTo(lottoNumber) == 0);
    }

    Set<LottoNumber> numbers() {
        return Collections.unmodifiableSet(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    void validateCount(List<Integer> input) {
        if (input.size() != COUNT) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumbers that = (LottoNumbers) o;

        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
