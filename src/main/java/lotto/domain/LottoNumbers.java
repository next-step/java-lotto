package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_NUMBER_COUNTS = 6;

    private final List<LottoNumber> values;

    private LottoNumbers(List<LottoNumber> values) {
        this.values = values;
    }

    public int matches(LottoNumbers numbers) {
        return (int) numbers.values
                .stream()
                .filter(this.values::contains)
                .count();
    }

    public static LottoNumbers from(List<LottoNumber> values) {
        verify(values);
        return new LottoNumbers(values);
    }

    private static void verify(List<LottoNumber> values) {
        if (values.size() != LOTTO_NUMBER_COUNTS) {
            throw new IllegalArgumentException("반드시 6개의 번호를 선택해야 합니다.");
        }

        if (isDuplicated(values)) {
            throw new IllegalArgumentException("중복된 번호를 선택할 수 없습니다.");
        }
    }

    private static boolean isDuplicated(List<LottoNumber> values) {
        return values.stream().distinct().count() != LOTTO_NUMBER_COUNTS;
    }

    @Override
    public String toString() {
        return values.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
