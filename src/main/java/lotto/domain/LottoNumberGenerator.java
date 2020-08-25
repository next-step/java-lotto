package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.CommonConstant.*;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        return IntStream.range(NUMBER_ONE, NUMBER_FORTY_SIX)
                .boxed()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> getAutoLottoNumber(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .distinct()
                .limit(NUMBER_SIX)
                .sorted()
                .collect(Collectors.toList());
    }

}
