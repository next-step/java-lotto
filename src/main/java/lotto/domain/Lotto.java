package lotto.domain;

import lotto.exception.InvalidLottoNumbersException;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public static Lotto of() {
        return new Lotto(LottoNumber.generate(LOTTO_SIZE));
    }

    public Lotto(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoNumbersException();
        }

        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public Rank getResult(WinningNumbers winningNumbers) {
        return Rank.getWinningType(toIntExact(countMatches(winningNumbers)), isBonusMatched(winningNumbers.getBonusNumber()));
    }

    private boolean isBonusMatched(int bonus) {
        return lottoNumbers.contains(bonus);
    }

    public static int getLottoSize() {
        return LOTTO_SIZE;
    }

    private long countMatches(WinningNumbers winningNumbers) {
        return winningNumbers.getWinningNumbers().stream()
                .filter(this::contains)
                .count();
    }

    private boolean contains(Integer number) {
        return lottoNumbers.contains(number);
    }

    public String toString(String format, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();

        String joinedNumbers = lottoNumbers.stream()
                .map(num -> Integer.toString(num))
                .collect(Collectors.joining(delimiter));
        stringBuilder.append(String.format(format, joinedNumbers));

        return stringBuilder.toString();
    }

    public static String calculateYield(int paidMoney, int profit) {
        return String.format("%.2f", (float) profit / (float) paidMoney);
    }
}
