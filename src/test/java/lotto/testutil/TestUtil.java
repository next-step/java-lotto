package lotto.testutil;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class TestUtil {

    public static List<LottoNumber> generateLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

}
