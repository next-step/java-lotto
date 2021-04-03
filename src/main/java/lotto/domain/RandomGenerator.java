package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerator implements LottoNumberGenerator {
    private final static int MIN = 0;
    private final static int MAX = 6;

    private static final List<LottoNumber> referenceNumbers = new ArrayList<>();

    static {
        for (int i = Lotto.LOTTO_FIRST_NUMBER; i <= Lotto.LOTTO_LAST_NUMBER; i++) {
            referenceNumbers.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> extractLottoNumber() {
        Collections.shuffle(referenceNumbers);

        return referenceNumbers.subList(MIN, MAX)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
