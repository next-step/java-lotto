package lotto.domain.vo;

import static java.util.stream.Collectors.*;

import java.util.List;

public class LottoResult {
    private final LottoNumbers lottoNumbers;

    public LottoResult(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(toList());

        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
