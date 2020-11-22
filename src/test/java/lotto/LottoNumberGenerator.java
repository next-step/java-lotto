package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public static List<LottoNumbers> create(int lottoCount) {

        List<Integer> range = IntStream.range(Lotto.NUMBER_MIN_RANGE, Lotto.NUMBER_MAX_RANGE)
                .boxed()
                .collect(Collectors.toList());

        return getLottoNumbers(lottoCount, range);

    }

    private static List<LottoNumbers> getLottoNumbers(int lottoCount, List<Integer> range) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Collections.shuffle(range);

            List<Integer> numbers = range.stream()
                    .limit(Lotto.NUMBER_RANGE)
                    .sorted()
                    .collect(Collectors.toList());

            lottoNumbers.add(new LottoNumbers(numbers));
        }
        return lottoNumbers;
    }
}
