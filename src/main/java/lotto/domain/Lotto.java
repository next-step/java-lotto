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

    private int countMatchedNumbers(List<Integer> winningNumbers) {
        return (int) this.lottoNumbers.getNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .filter(winningNumbers::contains)
                .count();
    }

    List<Integer> getNumbers() {
        return this.lottoNumbers.getNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
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
