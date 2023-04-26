package lotto.domain;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int BEGIN_OF_LOTTO_NUMBER = 1;
    private static final int END_OF_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> lottoNumberRepository;
    private final int lottoNumber;

    static {
        lottoNumberRepository = IntStream.range(BEGIN_OF_LOTTO_NUMBER, END_OF_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LottoNumber::new));
    }

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber createLottoNumber(int lottoNumber){
        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber createLottoNumber() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
