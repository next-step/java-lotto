package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import lotto.LottoMatchResult;
import lotto.LottoNumber;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoMatchResult> guess(WinningNumber winningNumber) {
        return lottoNumbers.stream().map(lottoNumber -> lottoNumber.match(winningNumber)).collect(Collectors.toList());
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers.stream().map(LottoNumber::getNumbers).collect(Collectors.toList());
    }
}
