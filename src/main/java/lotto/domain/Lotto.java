package lotto.domain;

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

    @Override
    public String toString() {
        String convertedNumbers = lottoNumbers.getNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[" + convertedNumbers + "]";
    }
}
