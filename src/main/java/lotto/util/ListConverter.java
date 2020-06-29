package lotto.util;

import lotto.domain.store.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ListConverter {

    private ListConverter() {}

    public static List<LottoNumber> convertCommaStringToLottoNumbers(final String commaString) {
        return Arrays.stream(commaString.split(","))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
