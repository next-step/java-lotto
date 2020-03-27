package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    LottoNumbers(LottoNumber... lottoNumbers) {
        this.lottoNumbers = Arrays.asList(lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<Long> checkWinningNumber(LottoNumber winningNumber) {
        return lottoNumbers.stream()
                .map(e -> e.getMatchCount(winningNumber))
                .collect(Collectors.toList());
    }

}
