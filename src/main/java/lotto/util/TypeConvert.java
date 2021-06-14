package lotto.util;

import lotto.model.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class TypeConvert {
    private static final String COMMA = ",";

    private TypeConvert() {
    }

    public static Set<LottoNumber> convertStringToLottoNumberSet(String inputSting) {
        List<String> stringList = Arrays.asList(inputSting.split(COMMA));

        return stringList.stream()
                .map((element) -> new LottoNumber(Integer.parseInt(element)))
                .collect(Collectors.toSet());
    }
}
