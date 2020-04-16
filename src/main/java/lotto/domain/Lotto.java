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

    public static List<Integer> valueOf(Lotto lotto) {
        return lotto.lottoNumbers;
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

    public Rank getMatchResult(WinningNumbers winningNumbers) {
        return Rank.getWinningType(countMatches(winningNumbers), isBonusMatched(winningNumbers));
    }

    private int countMatches(WinningNumbers winningNumbers) {
        return toIntExact(Lotto.valueOf(winningNumbers.getWinningNumbers()).stream()
                .filter(this::contains)
                .count());
    }

    private boolean isBonusMatched(WinningNumbers winningNumbers) {
        return lottoNumbers.contains(winningNumbers.getBonusNumber());
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
}
