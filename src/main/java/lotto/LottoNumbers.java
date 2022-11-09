package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("겹치지 않는 로또 숫자가 총 6개여야 합니다.");
        }

        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public static LottoNumbers of(int... numbers) {
        return new LottoNumbers(toLottoNumbers(numbers));
    }

    public static LottoNumbers of(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::of).collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers ofNumbers(List<LottoNumber> numbers) {
        return new LottoNumbers(numbers);
    }

    public boolean hasNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
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
        return Objects.hash(numbers);
    }


    private static List<LottoNumber> toLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public int getMatchCount(LottoNumbers ticket) {
        return (int) numbers.stream()
                .filter(ticket::hasNumber)
                .count();
    }
}
