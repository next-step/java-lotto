package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int SIZE = 6;
    public static final Money PRICE = Money.from(1_000);

    private final List<LottoNumber> values;

    private LottoNumbers(List<LottoNumber> values) {
        this.values = values;
    }

    public static LottoNumbers from(List<LottoNumber> values) {
        verify(values);
        return new LottoNumbers(values);
    }

    public int matches(LottoNumbers numbers) {
        return (int) numbers.values
                .stream()
                .filter(this.values::contains)
                .count();
    }

    private static void verify(List<LottoNumber> values) {
        if (values.size() != SIZE) {
            throw new IllegalArgumentException("반드시 6개의 번호를 선택해야 합니다.");
        }

        if (isDuplicated(values)) {
            throw new IllegalArgumentException("중복된 번호를 선택할 수 없습니다.");
        }
    }

    private static boolean isDuplicated(List<LottoNumber> values) {
        return values.stream().distinct().count() != SIZE;
    }

    @Override
    public String toString() {
        return values.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
