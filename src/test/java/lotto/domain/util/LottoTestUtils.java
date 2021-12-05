package lotto.domain.util;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTestUtils {

    public static final String PARAMETRIZED_TEST_NAME = "{displayName} [{index}] {arguments}";

    public static List<LottoNumber> lottoNumbers(String numbers) {
        return Arrays.stream(numbers.split("/"))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
