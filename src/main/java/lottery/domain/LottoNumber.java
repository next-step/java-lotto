package lottery.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final String ILLEGAL_LOTTO_NUMBER = "올바르지 못한 로또 번호입니다.";
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private static final Map<Integer, LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX + 1)
                                .boxed()
                                .collect(Collectors.toMap(Function.identity(), LottoNumber::new));
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = checkNumber(lottoNumber);
    }

    private int checkNumber(int lottoNumber) {
        if (!isLottoNumberRange(lottoNumber)) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER);
        }
        return lottoNumber;
    }

    private boolean isLottoNumberRange(int lottoNumber) {
        return lottoNumber >= LOTTO_NUMBER_MIN &&
            lottoNumber <= LOTTO_NUMBER_MAX;
    }

    public static LottoNumber of(int lottoNumber) {
        return Optional.ofNullable(lottoNumbers.get(lottoNumber))
                       .orElseThrow(() -> new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER));
    }

    public static List<LottoNumber> ofNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                           .map(LottoNumber::of)
                           .collect(Collectors.toList());
    }

    public static List<LottoNumber> ofRandom(int number) {
        return new Random().ints(number, LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX+1)
            .mapToObj(lottoNumbers::get)
            .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumber that = (LottoNumber) o;

        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
