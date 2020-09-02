package kr.heesu.lotto.utils;

import kr.heesu.lotto.domain.Lotto;
import kr.heesu.lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoFactory {
    private static final String DELIMITER = ", ";
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int SIZE = 6;
    private static final List<LottoNumber> RANGE;

    static {
        RANGE = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private LottoFactory() {}

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(RANGE);
        return Collections.unmodifiableList(RANGE.subList(0, SIZE));
    }

    public static Set<Lotto> createAutoLottoSet(int size) {
        Set<Lotto> lottoSet = new HashSet<>();

        while (lottoSet.size() < size) {
            List<LottoNumber> lottoNumbers = generateLottoNumbers();
            lottoSet.add(Lotto.of(lottoNumbers));
        }

        return lottoSet;
    }

    public static Set<Lotto> createManualLottoSet(String manualLottoInput) {
        Set<Lotto> lottoSet = new HashSet<>();
        String[] values = manualLottoInput.split("\n");

        Arrays.stream(values)
                .map(LottoFactory::createLottoFromUserInput)
                .forEach(lottoSet::add);

        if (values.length != lottoSet.size()) {
            throw new IllegalArgumentException();
        }
        return lottoSet;
    }

    public static Lotto createLottoFromUserInput(String input) {
        List<LottoNumber> numbers = Stream.of(input.split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        return Lotto.of(numbers);
    }
}
