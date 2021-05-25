package lotto.util;

import lotto.model.LottoNumber;

import java.util.*;

public class TypeConvert {
    private static final String STRING_SEPARATOR = ",";

    public static Set<LottoNumber> convertStringToLottoNumberSet(String inputSting) {
        List<String> stringList = Arrays.asList(inputSting.split(STRING_SEPARATOR));
        Set<LottoNumber> convertedSet = new HashSet<>();

        for (String element : stringList) {
            convertedSet.add(new LottoNumber(Integer.parseInt(element)));
        }

        return convertedSet;
    }
}
