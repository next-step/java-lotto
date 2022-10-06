package lotto.domain.vo;

import static java.util.stream.Collectors.*;

import java.util.List;

public class LottoResult {
    private final LottoNumbers lottoNumbers;

    public LottoResult(List<Integer> numbers) {
        this.lottoNumbers = LottoNumbers.valueOf(numbers);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
