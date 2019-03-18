package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private static final Integer limitCount = 6;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public WinningNumbers(Integer ...numbers) {
        Arrays.stream(numbers)
            .map(LottoNumber::new)
            .distinct()
            .limit(limitCount)
            .forEach(lottoNumbers::add);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
