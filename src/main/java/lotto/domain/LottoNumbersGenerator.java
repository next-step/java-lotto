package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoNumbersGenerator {

    private static final String INVALID_RANGE_EXCEPTION_MESSAGE_FORMAT = "로또 번호 생성 범위가 유효하지 않습니다. lowerBound: %s, upperBound: %s";
    private static final int FIRST_LOTTO_NUMBER = 0;

    private final List<LottoNumber> sourceLottoNumbers;

    private LottoNumbersGenerator(List<LottoNumber> sourceLottoNumbers) {
        this.sourceLottoNumbers = Objects.requireNonNull(sourceLottoNumbers);
    }

    public static LottoNumbersGenerator rangeClosed(int lowerBound, int upperBound) {
        validateRange(lowerBound, upperBound);
        return new LottoNumbersGenerator(createLottoNumbers(lowerBound, upperBound));
    }

    private static void validateRange(int lowerBound, int upperBound) {
        if (sizeOf(lowerBound, upperBound) < LottoNumbers.requiredSize()) {
            throw new IllegalArgumentException(String.format(INVALID_RANGE_EXCEPTION_MESSAGE_FORMAT, lowerBound, upperBound));
        }
    }

    private static int sizeOf(int lowerBound, int upperBound) {
        return (upperBound + 1) - lowerBound;
    }

    private static List<LottoNumber> createLottoNumbers(int lowerBound, int upperBound) {
        return IntStream.rangeClosed(lowerBound, upperBound)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public List<LottoNumbers> generate(long quantity) {
        return Stream.generate(this::generate)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    private LottoNumbers generate() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while(lottoNumbers.size() < LottoNumbers.requiredSize()) {
            lottoNumbers.add(pickRandomLottoNumber());
        }
        return LottoNumbers.of(new ArrayList<>(lottoNumbers));
    }

    private LottoNumber pickRandomLottoNumber() {
        Collections.shuffle(sourceLottoNumbers);
        return sourceLottoNumbers.get(FIRST_LOTTO_NUMBER);
    }
}
