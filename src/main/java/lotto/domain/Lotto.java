package lotto.domain;

import lotto.exception.InvalidLottoNumbersException;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public static Lotto getNewInstance() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            lottoNumbers.add(LottoNumber.getRandomInstance());
        }
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    public static Lotto of(List<Integer> numbers) {
        if (!isValidNumbers(numbers)) {
            throw new InvalidLottoNumbersException();
        }

        return new Lotto(numbers.stream()
                .map(LottoNumber::getInstance)
                .collect(Collectors.toList()));
    }

    private static boolean isValidNumbers(List<Integer> numbers) {
        return !Objects.isNull(numbers) &&
                numbers.size() == LOTTO_SIZE;
    }

    public static List<LottoNumber> valueOf(Lotto lotto) {
        return lotto.lottoNumbers;
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public int countMatches(Lotto lotto) {
        return toIntExact(Lotto.valueOf(lotto).stream()
                .filter(this::isContain)
                .count());
    }

    public boolean isContain(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public String toString(String format, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();

        String joinedNumbers = lottoNumbers.stream()
                .map(num -> Integer.toString(LottoNumber.valueOf(num)))
                .collect(Collectors.joining(delimiter));
        stringBuilder.append(String.format(format, joinedNumbers));

        return stringBuilder.toString();
    }

}
