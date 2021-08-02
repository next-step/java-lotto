package lotto.domain.model;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.exception.LottoNumberOutOfRangeException;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int BOTTOM_OF_RANGE_INCLUSIVE = 1;
    public static final int TOP_OF_RANGE_INCLUSIVE = 45;

    private static final Map<Integer, LottoNumber> mapToLottoNumbers =
            IntStream.range(BOTTOM_OF_RANGE_INCLUSIVE, TOP_OF_RANGE_INCLUSIVE + 1)
                    .boxed()
                    .collect(Collectors.toMap(Function.identity(), LottoNumber::new));

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(mapToLottoNumbers.get(number))
                .orElseThrow(LottoNumberOutOfRangeException::new);
    }

    public static LottoNumber of(String text) {
        return of(Integer.parseInt(text));
    }

    public int value() {
        return lottoNumber;
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < BOTTOM_OF_RANGE_INCLUSIVE || lottoNumber > TOP_OF_RANGE_INCLUSIVE) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    @Override
    public int compareTo(LottoNumber that) {
        return Integer.compare(this.lottoNumber, that.lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
