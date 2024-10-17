package lotto.domain.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TestLottoNumberFactory {

    public static List<LottoNumber> createLottoNumbers(Integer... numbers) {
        return Arrays.stream(numbers)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
