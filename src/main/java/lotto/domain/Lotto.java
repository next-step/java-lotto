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

    LottoResultType findLottoResultType(List<Integer> winningNumbers) {
        return LottoResultType.findByMatchedCount(countMatchedNumbers(winningNumbers));
    }

    List<Integer> getNumbers() {
        return this.lottoNumbers.getNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("[%s]", numbers());
    }

    private String numbers() {
        return lottoNumbers.getNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private int countMatchedNumbers(List<Integer> winningNumbers) {
        return this.lottoNumbers.matchedCount(winningNumbers);
    }
}
