package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int BEGIN_OF_LOTTO_NUMBER = 1;
    private static final int END_OF_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> lottoNumberRepository;
    private static final List<Integer> repositoryKeySet;
    private final int lottoNumber;

    static {
        lottoNumberRepository = IntStream.rangeClosed(BEGIN_OF_LOTTO_NUMBER, END_OF_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LottoNumber::new));

        repositoryKeySet = new ArrayList<>(lottoNumberRepository.keySet());
    }

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber provideLottoNumber(int lottoNumber) {
        return lottoNumberRepository.get(lottoNumber);
    }

    public static LottoNumber provideLottoNumber() {

        // lottoNumberRepository
        return null;
    }

    public boolean isCorrectRange(LottoNumber lottoNumber) {

        LottoNumber beginOfLottoNumber = provideLottoNumber(BEGIN_OF_LOTTO_NUMBER);

        if (lottoNumber.hashCode() < beginOfLottoNumber.hashCode()) {
            return false;
        }

        LottoNumber endOfLottoNumber = provideLottoNumber(END_OF_LOTTO_NUMBER);

        return lottoNumber.hashCode() <= endOfLottoNumber.hashCode();
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
