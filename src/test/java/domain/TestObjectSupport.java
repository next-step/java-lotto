package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestObjectSupport {
    public static List<LottoNumber> convertToLottoNumberList(List<Integer> integers) {
        return integers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
    public static LottoNumbers createLottoNumbers() {
        return new LottoNumbers(convertToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
