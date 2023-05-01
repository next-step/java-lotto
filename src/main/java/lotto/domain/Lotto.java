package lotto.domain;

import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidLottoParsingNumberException;
import lotto.domain.exception.InvalidLottoSizeException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final Set<Integer> lottoNumberSet;

    public Lotto(Set<Integer> lottoNumberSet) {
        checkLottoNumbers(lottoNumberSet);

        this.lottoNumberSet = lottoNumberSet;
    }

    public Set<Integer> getLottoNumberSet() {
        return Set.copyOf(lottoNumberSet);
    }

    public boolean hasNumber(int number) {
        return lottoNumberSet.contains(number);
    }

    private void checkLottoNumbers(Set<Integer> lottoNumberSet) {
        if (lottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoSizeException(
                    "입력한 갯수 : ",
                    String.valueOf(lottoNumberSet.size())
            );
        }

        if (!isBetweenMinAndMax(lottoNumberSet)) {
            throw new InvalidLottoNumberException(
                    "입력한 숫자 : ",
                    lottoNumberSet.toString()
            );
        }
    }

    private boolean isBetweenMinAndMax(Set<Integer> lottoNumberSet) {
        return lottoNumberSet.stream()
                .noneMatch(it ->
                        it < MINIMUM_LOTTO_NUMBER ||
                                it > MAXIMUM_LOTTO_NUMBER
                );
    }

    public static Lotto from(int[] lottoNumberArray) {
        return new Lotto(Arrays.stream(lottoNumberArray).boxed().collect(Collectors.toSet()));
    }

    public static Lotto from(List<Integer> lottoNumberList) {
        return new Lotto(Set.copyOf(lottoNumberList));
    }

    public static Lotto from(String lottoNumberString) {
        return new Lotto(Arrays.stream(lottoNumberString.split(","))
                .map(it -> toInt(it.trim()))
                .collect(Collectors.toSet())
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
