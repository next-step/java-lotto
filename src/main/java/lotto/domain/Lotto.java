package lotto.domain;

import lotto.domain.exception.DuplicatedLottoNumberExcetion;
import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidLottoParsingNumberException;
import lotto.domain.exception.InvalidLottoSizeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int[] lottoNumbers;

    public Lotto(int[] lottoNumbers) {
        checkLottoNumbers(lottoNumbers);

        this.lottoNumbers = Arrays.stream(lottoNumbers)
                .sorted()
                .toArray();
    }

    public int[] getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean hasNumber(int number) {
        return Arrays.stream(lottoNumbers)
                .anyMatch(it -> it == number);
    }

    private void checkLottoNumbers(int[] lottoNumbers) {
        if (lottoNumbers.length != LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoSizeException(
                    "입력한 갯수 : ",
                    String.valueOf(lottoNumbers.length)
            );
        }

        if (!isBetweenMinAndMax(lottoNumbers)) {
            throw new InvalidLottoNumberException(
                    "입력한 숫자 : ",
                    Arrays.toString(lottoNumbers)
            );
        }

        if (!hasUniqueNumbers(lottoNumbers)) {
            throw new DuplicatedLottoNumberExcetion(
                    "입력한 숫자 : ",
                    Arrays.toString(lottoNumbers)
            );
        }
    }

    private boolean isBetweenMinAndMax(int[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .noneMatch(it ->
                        it < MINIMUM_LOTTO_NUMBER ||
                                it > MAXIMUM_LOTTO_NUMBER
                );
    }

    private boolean hasUniqueNumbers(int[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .distinct()
                .count() == LOTTO_NUMBER_SIZE;
    }

    public static Lotto from(List<Integer> lottoNumberList) {
        return new Lotto(lottoNumberList.stream()
                .mapToInt(it -> it)
                .toArray()
        );
    }

    public static Lotto from(String lottoNumberString) {
        return from(Arrays.stream(lottoNumberString.split(","))
                .map(it -> toInt(it.trim()))
                .collect(Collectors.toList())
        );
    }

    private static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new InvalidLottoParsingNumberException(exception, "입력한 문자열 : ", input);
        }
    }
}
