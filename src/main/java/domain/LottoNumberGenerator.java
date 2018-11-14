package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int PICK = 6;
    private static final Map<Integer, LottoNumber> NUMBER_CANDIDATES = new HashMap<>();

    static {
        IntStream
            .range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER + 1)
            .forEach(i -> NUMBER_CANDIDATES.put(i, new LottoNumber(i)));
    }

    public static LottoNumbers generateNumbers() {
        List<Integer> numbers = IntStream
            .range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(numbers);

        List<LottoNumber> lottoNumbers = numbers.subList(0, PICK)
            .stream()
            .map(NUMBER_CANDIDATES::get)
            .sorted()
            .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }
}
