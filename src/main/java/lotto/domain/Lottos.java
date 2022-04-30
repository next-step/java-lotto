package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_INCLUSIVE = 0;
    private static final int LOTTO_PRICE = 1000;

    private final List<LottoNumbers> lottoNumbers;

    public Lottos(int userAmount) {
        this(getRandomLottoNumbers(userAmount));
    }

    protected Lottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private static List<LottoNumbers> getRandomLottoNumbers(int userAmount) {
        return IntStream.range(START_INCLUSIVE, userAmount / LOTTO_PRICE)
                .mapToObj(it -> new LottoNumbers())
                .collect(Collectors.toList());
    }

    public int length() {
        return this.lottoNumbers.size();
    }

    public List<Integer> findMatch(String previousWeekWinningNumber) {
        String[] winningNumbers = previousWeekWinningNumber.split(", ");

        return this.lottoNumbers.stream()
                .map(lottoNumber -> (int) Arrays.stream(winningNumbers)
                        .filter(winningNumber -> lottoNumber.contains(new LottoNumber(winningNumber)))
                        .count()
                ).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.lottoNumbers.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining("\n"));
    }
}
