package lotto.domain;

import lotto.exception.InvalidLottoNumbersException;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = LottoNumber.generate(LOTTO_SIZE);
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

    public String toString(String format, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();

        String joinedNumbers = lottoNumbers.stream()
                .map(num -> Integer.toString(num))
                .collect(Collectors.joining(delimiter));
        stringBuilder.append(String.format(format, joinedNumbers));

        return stringBuilder.toString();
    }

    public Winning getResult(List<Integer> winningNumbers) {
        int matchCount = 0;

        for (Integer number : winningNumbers) {
            matchCount += lottoNumbers.contains(number) ? 1 : 0;
        }

        return Winning.getWinningType(matchCount);
    }

    public static String calculateYield(int paidMoney, int profit) {
        return String.format("%.2f", (float) profit / (float) paidMoney);
    }
}
