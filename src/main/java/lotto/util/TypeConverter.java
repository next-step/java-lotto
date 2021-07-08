package lotto.util;

import lotto.model.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class TypeConverter {
    private static final String COMMA = ",";
    private static final int INDEX_VALUE = 1;

    private TypeConverter() {
    }

    public static Set<LottoNumber> convertStringToLottoNumberSet(String inputSting) {
        return Arrays.stream(inputSting.split(COMMA))
                .map(splitString -> Integer.parseInt(splitString))
                .map(splitInteger -> new LottoNumber(splitInteger))
                .collect(Collectors.toSet());
    }
    public static Set<Integer> convertStringToIntegerSet(String inputSting) {
        return Arrays.stream(inputSting.split(COMMA))
                .map(splitString -> Integer.parseInt(splitString)-INDEX_VALUE)
                .collect(Collectors.toSet());
    }
}
