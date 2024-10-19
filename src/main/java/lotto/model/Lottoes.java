package lotto.model;

import lotto.util.NumbersCreator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottoes {

    public static final int START = 0;
    private final List<Lotto> lottoes;
    public Lottoes(final List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }
    public Lottoes(final int buyCount, final NumbersCreator numbersCreator) {
        this(createAutoLottoes(buyCount, numbersCreator));
    }

    public Lottoes(Lottoes manualLottoes, Lottoes autoLottoes) {
        this(createManualAndAutoLottoes(manualLottoes, autoLottoes));
    }

    private static List<Lotto> createManualAndAutoLottoes(Lottoes manualLottoes, Lottoes autoLottoes) {
        List<Lotto> result = new ArrayList<>(manualLottoes.value());
        result.addAll(autoLottoes.value());
        return result;
    }

    private static List<Lotto> createAutoLottoes(int buyCount, NumbersCreator numbersCreator) {
        return IntStream.range(START, buyCount)
                .mapToObj(i -> new Lotto(numbersCreator))
                .collect(Collectors.toList());
    }

    public List<Lotto> value() {
        return Collections.unmodifiableList(this.lottoes);
    }
}
