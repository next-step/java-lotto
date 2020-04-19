package Lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_SIZE = 6;
    private static final String COMMA_WITH_SPACE = ", ";
    private static final String DELIMITER = ",";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    private final Set<LottoNumber> lottoNumberSet;

    private LottoNumbers(final Set<LottoNumber> lottoNumberSet) {
        validateLottoSize(lottoNumberSet);
        this.lottoNumberSet = new TreeSet<>(lottoNumberSet);
    }

    public static LottoNumbers of(final Set<LottoNumber> lottoNumberSet) {
        return new LottoNumbers(lottoNumberSet);
    }

    public static LottoNumbers of(final List<Integer> numbers) {
        return new LottoNumbers(numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet()));
    }

    public static LottoNumbers of(final String inputString) {
        return of(Arrays.stream(inputString.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private void validateLottoSize(final Set<LottoNumber> lottoNumberSet) {
        final int lottoSize = lottoNumberSet.size();
        if (lottoSize != LOTTO_SIZE) {
            throw new IllegalArgumentException("Size of Lotto is wrong: " + lottoSize);
        }
    }

    public int match(final LottoNumbers winningNumbers) {
        return this.lottoNumberSet.stream().mapToInt(winningNumbers::increment).sum();
    }

    public int increment(final LottoNumber number) {
        return this.lottoNumberSet.contains(number) ? 1 : 0;
    }

    @Override
    public String toString() {
        return this.lottoNumberSet.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(COMMA_WITH_SPACE, PREFIX, SUFFIX));
    }
}
