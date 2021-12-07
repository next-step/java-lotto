package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> values;

    private LottoNumbers(List<LottoNumber> input) {
        this.values = input;
    }

    public static LottoNumbers from(List<Integer> input) {
        if (isValidDigits(input)) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }

        if(isDuplicated(input)) {
            throw new IllegalArgumentException("로또 번호는 중복이 없어야 합니다.");
        }

        List<LottoNumber> lottoNumbers = input.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }

    private static boolean isValidDigits(List<Integer> input) {
        return input == null || input.size() != 6;
    }

    private static boolean isDuplicated(List<Integer> input) {
        return input.stream()
                .distinct()
                .count() != input.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "values=" + values +
                '}';
    }
}
