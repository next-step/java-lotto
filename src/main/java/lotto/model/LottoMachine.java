package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;
import static lotto.model.Lotto.NUMBER_OF_LOTTO_COUNT;
import static lotto.model.LottoNumber.MAX_OF_LOTTO_NUMBER;
import static lotto.model.LottoNumber.MIN_OF_LOTTO_NUMBER;

public final class LottoMachine {
    private static final LottoMachine INSTANCE = new LottoMachine();
    private static final Set<LottoNumber> LOTTO_NUMBERS_RANGE = unmodifiableSet(rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
                                                                                        .mapToObj(LottoNumber::from)
                                                                                        .collect(toSet()));

    private LottoMachine() {}

    public static LottoMachine getInstance() {
        return INSTANCE;
    }

    public Lotto manual(String string) {
        return Lotto.from(string);
    }

    public Lotto auto() {
        List<LottoNumber> shuffleList = shuffle();
        return Lotto.from(shuffleList.subList(0, NUMBER_OF_LOTTO_COUNT));
    }

    private List<LottoNumber> shuffle() {
        List<LottoNumber> list = new ArrayList<>(LOTTO_NUMBERS_RANGE);
        Collections.shuffle(list);
        return list;
    }
}
