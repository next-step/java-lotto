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

    private static List<Integer> lottoNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());
    private final List<Integer> lotto;


    public Lotto() {
        this(randomNumberGenerate());
    }

    public Lotto(List<Integer> randomNumbers) {
        this.lotto = randomNumbers;
    }

    public Rank winningResult(WinningNumber winningNumber) {
        int matchCount = (int) winningNumber.stream()
                .filter(this.lotto::contains)
                .count();
        Boolean isBonusMatch = this.lottoNumbers.contains(winningNumber.getBonusNumber());
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
