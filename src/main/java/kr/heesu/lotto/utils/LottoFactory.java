package kr.heesu.lotto.utils;

import kr.heesu.lotto.domain.Lotto;
import kr.heesu.lotto.domain.LottoNumber;
import kr.heesu.lotto.domain.Lottos;
import kr.heesu.lotto.domain.ManualLottoInputs;
import kr.heesu.lotto.enums.ExceptionMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    private static Lotto createLotto(List<LottoNumber> numbers) {
        return Lotto.of(numbers);
    }

    public static Lottos createAutoLottos(int size) {
        Set<Lotto> lottoSet = new HashSet<>();

        while (lottoSet.size() < size) {
            List<LottoNumber> lottoNumbers = generateLottoNumbers();
            lottoSet.add(createLotto(lottoNumbers));
        }

        return Lottos.of(lottoSet);
    }

    public static Lottos createManualLottos(ManualLottoInputs inputs) {
        Set<Lotto> lottoList = new HashSet<>();

        inputs.getLottoInputs()
                .stream()
                .map(LottoFactory::createLottoFromUserInput)
                .forEach(lottoList::add);

        if (lottoList.size() != inputs.getSize()) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_FOR_LOTTO_NUMBER.getMessage());
        }

        return Lottos.of(lottoList);
    }

    public static Lotto createLottoFromUserInput(String input) {
        List<LottoNumber> numbers = Stream.of(input.split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        return Lotto.of(numbers);
    }
}
