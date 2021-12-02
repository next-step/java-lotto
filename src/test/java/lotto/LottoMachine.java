package lotto;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class LottoMachine {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final List<Integer> LIST = rangeClosed(MIN, MAX).boxed().collect(toList());

    public static List<LottoNumber> draw() {
        Collections.shuffle(LIST);
        List<Integer> drawnLottoNumbers = LIST.stream()
                .limit(6)
                .sorted()
                .collect(toList());

        return drawnLottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(toList());
    }
}
