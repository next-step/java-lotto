package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AutoLottoGenerator implements LottoGenerator {
    private static final List<LottoNumber> DECK = new ArrayList<>(LottoNumber.totalNumbers());
    private static final int HEAD = 0;

    private static final AutoLottoGenerator instance = new AutoLottoGenerator();

    public static AutoLottoGenerator getInstance() {
        return instance;
    }

    private AutoLottoGenerator() {}

    @Override
    public Lotto generate() {
        Collections.shuffle(DECK);
        return Lotto.fromLottoNumbers(new TreeSet<>(DECK.subList(HEAD, Lotto.SIZE_OF_NUMBERS)));
    }
}
