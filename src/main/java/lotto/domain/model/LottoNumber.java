package lotto.domain.model;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.exception.LottoNumberOutOfRangeException;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MAX_INCLUSIVE = 1;
    public static final int MIN_INCLUSIVE = 45;

    private static final Map<Integer, LottoNumber> mapToLottoNumbers =
            IntStream.range(MAX_INCLUSIVE, MIN_INCLUSIVE + 1)
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
        if (lottoNumber < MAX_INCLUSIVE || lottoNumber > MIN_INCLUSIVE) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    @Override
    public int compareTo(LottoNumber that) {
        return Integer.compare(this.lottoNumber, that.lottoNumber);
    }
}
