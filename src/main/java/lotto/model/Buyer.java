package lotto.model;

import lotto.util.BonusCreator;
import lotto.util.NumbersCreator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buyer {

    public static final int START = 0;
    private final List<Lotto> lottoes;
    private Buyer(final List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public Buyer(final int buyCount, final NumbersCreator numbersCreator) {
        this(IntStream.range(START, buyCount)
                .mapToObj(i -> new Lotto(numbersCreator))
                .collect(Collectors.toList()));
    }

    public List<Lotto> value() {
        return Collections.unmodifiableList(this.lottoes);
    }
}
