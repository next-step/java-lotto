package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1_000;

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    LottoResultType findLottoResultType(Lotto winningLotto) {
        int matchedCount = lottoNumbers.countMatchedNumbers(winningLotto.lottoNumbers);
        return LottoResultType.findByMatchedCount(matchedCount);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
}
