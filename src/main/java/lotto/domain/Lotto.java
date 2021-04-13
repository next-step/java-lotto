package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 45;
    private final static int NUMBER_OF_LOTTO_NUMBERS = 6;
    private final static int LOTTO_PRICE = 1000;

    private final static List<Integer> lottoNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());
    private final List<Integer> lotto;


    public Lotto() {
        this(randomNumberGenerate());
    }

    public Lotto(List<Integer> numbers) {
        this.lotto = numbers;
    }

    public Rank winningResult(WinningNumber winningNumber) {
        int matchCount = (int) winningNumber.stream()
                .filter(this.lotto::contains)
                .count();
        boolean isBonusMatch = winningNumber.isContained(this.lotto);
        return Rank.valueOf(matchCount, isBonusMatch);
    }

    public static int lottoPrice() {
        return LOTTO_PRICE;
    }

    private static List<Integer> randomNumberGenerate() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(NUMBER_OF_LOTTO_NUMBERS)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
