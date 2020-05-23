package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    private static final List<LottoNumber> RANGED_LOTTO_NUMBERS =
            IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                    .boxed()
                    .map(LottoNumber::of)
                    .collect(Collectors.toList());

    private LottoNumbersGenerator() {}

    public static List<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = generateRangeNumbers();
        Collections.shuffle(lottoNumbers);

        return extractAndSortNumbers(lottoNumbers);
    }

    private static List<LottoNumber> generateRangeNumbers() {
        return new ArrayList<>(RANGED_LOTTO_NUMBERS);
    }

    private static List<LottoNumber> extractAndSortNumbers(final List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .limit(LottoNumbers.LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
