package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public static LottoNumbers from(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public int size() {
        return numbers.size();
    }

    public LottoResult computeLottoResult(WinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult(numbers.size());
        for (LottoNumber lottoNumber : numbers) {
            int containsCount = winningNumber.containsCount(lottoNumber);
            lottoResult.addCorrectLottoCount(containsCount, winningNumber.isContainBonusNumber(lottoNumber));
        }
        return lottoResult;
    }

    public List<String> getLottoNumbersToString() {
        return numbers
                .stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toList());
    }

    public boolean containsExactly(LottoNumber... lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .allMatch(numbers::contains);
    }
}
