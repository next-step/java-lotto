package step2.domain;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SplitNumber {
    private SplitNumber() {
    }

    public static Set<LottoNumber> getLottoNumbers(String winnersNumbers) {
        return Arrays.stream(winnersNumbers.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
