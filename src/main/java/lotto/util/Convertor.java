package lotto.util;

import lotto.domains.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    private static final String SPLIT_REGEX = ",";

    public static List<LottoNumber> convertStringToList(String data) {
        return Arrays.stream(data.split(SPLIT_REGEX))
                .map(number -> LottoNumber.of(Integer.parseInt(number.trim())))
                .collect(Collectors.toList());
    }
}
