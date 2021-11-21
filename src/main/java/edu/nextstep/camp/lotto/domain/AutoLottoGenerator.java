package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    private static final List<LottoNumber> numbers = new ArrayList<>(LOTTO_MAX);
    private static final AutoLottoGenerator instance = new AutoLottoGenerator();

    static {
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            numbers.add(LottoNumber.of(i));
        }
    }

    public static AutoLottoGenerator getInstance() {
        return instance;
    }

    private AutoLottoGenerator() {}

    @Override
    public Lotto generate() {
        List<LottoNumber> deck = new ArrayList<>(numbers);
        Collections.shuffle(deck);
        return Lotto.of(deck.subList(0, 6));
    }
}
