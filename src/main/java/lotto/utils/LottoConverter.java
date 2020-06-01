package lotto.utils;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoConverter {

    private static final String SEPARATOR = ",";

    private LottoConverter() {
    }

    public static List<LottoNumbers> convertToLottoNumbers(List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(LottoConverter::convertToIntArray)
                .map(LottoNumbers::of)
                .collect(Collectors.toList());
    }

    public static Set<LottoNumber> convertToLottoNumber(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    private static int[] convertToIntArray(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
