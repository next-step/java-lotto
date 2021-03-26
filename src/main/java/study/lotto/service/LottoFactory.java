package study.lotto.service;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.view.dto.ManualLottoParser;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoFactory {

    public static final int MAX_NUMBER_BOUND = 45;
    public static final int MIN_NUMBER_BOUND = 1;
    public static final int LOTTO_MAX_SIZE = 6;

    public static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(MIN_NUMBER_BOUND, MAX_NUMBER_BOUND)
                .boxed()
                .map(LottoNumber::of)
                .collect(toList());
    }

    private LottoFactory() { }

    public static List<Lotto> createManualAndAuto(final int totalCount, final ManualLottoParser manualLottoNumbers) {
        return Stream.of(createManualLottoSet(manualLottoNumbers), createAutoLottoSet(totalCount))
                .flatMap(Collection::stream)
                .collect(toList());
    }

    protected static List<Lotto> createManualLottoSet(final ManualLottoParser manualLottoNumbers) {
        List<Set<Integer>> manualNumbers = manualLottoNumbers.getManualNumbers();
        return manualNumbers.stream()
                .map(LottoFactory::makeManualLottoSet)
                .map(Lotto::of)
                .collect(Collectors.toList());
    }

    protected static List<Lotto> createAutoLottoSet(final int totalCount) {
        return Stream.generate(LottoFactory::makeLottoNumbers)
                .limit(totalCount)
                .collect(toList());
    }

    private static Lotto makeLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return Lotto.of(LOTTO_NUMBERS.stream()
                .limit(LOTTO_MAX_SIZE)
                .collect(toList()));
    }

    private static List<LottoNumber> makeManualLottoSet(final Set<Integer> integers) {
        return integers.stream()
                .map(LottoNumber::of)
                .collect(toList());
    }
}
