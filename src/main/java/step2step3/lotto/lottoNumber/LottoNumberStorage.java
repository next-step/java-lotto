package step2step3.lotto.lottoNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toUnmodifiableList;

public class LottoNumberStorage {

    private final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private LottoNumberStorage() {
    }

    public static LottoNumberStorage lottoNumberStorage() {
        return LottoNumberStorageFactory.LOTTO_NUMBER_STORAGE;
    }

    private static class LottoNumberStorageFactory {
        private static final LottoNumberStorage LOTTO_NUMBER_STORAGE = new LottoNumberStorage();
    }

    public List<LottoNumber> lottoNumbers(NumbersGenerator numbersGenerator) {
        Set<Integer> numbers = numbersGenerator.numbers();

        return numbers.stream()
                .map(this::lottoNumber)
                .sorted()
                .collect(toUnmodifiableList());
    }

    private LottoNumber lottoNumber(int number) {
        if (lottoNumbers.containsKey(number)) {
            return lottoNumbers.get(number);
        }

        LottoNumber lottoNumber = new LottoNumber(number);
        lottoNumbers.put(number, lottoNumber);
        return lottoNumber;
    }
}
