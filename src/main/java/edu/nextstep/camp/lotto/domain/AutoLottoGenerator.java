package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
    private static final AutoLottoGenerator instance = new AutoLottoGenerator();

    public static AutoLottoGenerator getInstance() {
        return instance;
    }

    private AutoLottoGenerator() {}

    @Override
    public Lotto generate() {
        List<LottoNumber> deck = new ArrayList<>(LottoNumber.totalNumbers());
        Collections.shuffle(deck);
        return Lotto.fromLottoNumbers(deck.subList(0, 6));
    }
}
