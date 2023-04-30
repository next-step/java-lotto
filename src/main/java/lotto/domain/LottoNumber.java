package lotto.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int BEGIN_OF_LOTTO_NUMBER = 1;
    private static final int END_OF_LOTTO_NUMBER = 45;
    private static final int ZERO = 0;
    private static final Map<Integer, LottoNumber> lottoNumberRepository;
    private final int lottoNumber;

    static {
        lottoNumberRepository = IntStream.rangeClosed(BEGIN_OF_LOTTO_NUMBER, END_OF_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LottoNumber::new));
    }

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber provideLottoNumber(int requestNumber) {

        LottoNumber lottoNumber = lottoNumberRepository.get(requestNumber);

        if (!isCorrectRange(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호 범위가 아니에요 :(");
        }

        return lottoNumber;
    }

    public static LottoNumber provideLottoNumber() {
        List<Integer> numberList = extractNumber();
        Collections.shuffle(numberList);
        return provideLottoNumber(numberList.get(ZERO));
    }

    private static List<Integer> extractNumber() {
        return new ArrayList<>(lottoNumberRepository.keySet());
    }

    public static boolean isCorrectRange(LottoNumber lottoNumber) {

        LottoNumber beginOfLottoNumber = lottoNumberRepository.get(BEGIN_OF_LOTTO_NUMBER);

        if (Objects.isNull(lottoNumber)) {
            return Boolean.FALSE;
        }

        if (lottoNumber.hashCode() < beginOfLottoNumber.hashCode()) {
            return Boolean.FALSE;
        }

        LottoNumber endOfLottoNumber = lottoNumberRepository.get(END_OF_LOTTO_NUMBER);

        return lottoNumber.hashCode() <= endOfLottoNumber.hashCode();
    }

    public boolean isSameLottoNumber(LottoNumber leftOperand) {
        return leftOperand == this;
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

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
