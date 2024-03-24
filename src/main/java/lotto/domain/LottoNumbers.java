package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final String INVALID_LOTTO_NUMBER_SIZE = "로또 번호는 " + LOTTO_NUMBER_SIZE + "개여야 합니다.";
    private static final String LOTTO_NUMBER_CANT_DUPLICATE = "로또 번호는 중복될 수 없습니다.";

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers from(List<Integer> values) {
        validate(values);
        Collections.sort(values);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : values) {
            lottoNumbers.add(LottoNumber.valueOf(number));
        }

        return new LottoNumbers(lottoNumbers);
    }

    private static void validate(List<Integer> numbers) {
        if (isInvalidLottoNumberSize(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE);
        }

        if (isLottoNumberDuplicate(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_CANT_DUPLICATE);
        }
    }

    private static boolean isInvalidLottoNumberSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_SIZE;
    }

    private static boolean isLottoNumberDuplicate(List<Integer> numbers) {
        int originalSize = numbers.size();
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();

        return originalSize != distinctCount;
    }

    public int size() {
        return numbers.size();
    }

    public int containsCount(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isContainNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
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
}
