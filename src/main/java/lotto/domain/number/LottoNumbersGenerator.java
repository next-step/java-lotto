package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    private static final List<Integer> RANGED_LOTTO_NUMBERS =
            IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                    .boxed()
                    .collect(Collectors.toList());

    private LottoNumbersGenerator() {}

    public static List<LottoNumber> generate() {
        List<Integer> lottoNumbers = generateRangeNumbers();
        Collections.shuffle(lottoNumbers);

        return convertToLottoNumbers(extractAndSortNumbers(lottoNumbers));
    }

    private static List<Integer> generateRangeNumbers() {
        return new ArrayList<>(RANGED_LOTTO_NUMBERS);
    }

    private static List<Integer> extractAndSortNumbers(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .limit(LottoNumbers.LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> convertToLottoNumbers(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
