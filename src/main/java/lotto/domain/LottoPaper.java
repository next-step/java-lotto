package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPaper {
    private final List<LottoNum> lottoNumbers;

    public LottoPaper(List<LottoNum> numberList) {
        lottoNumbers = numberList;
    }

    public List<LottoNum> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> getLottoNumbersToIntegerList() {
        return lottoNumbers.stream()
                .map(LottoNum::getLottoNum)
                .collect(Collectors.toList());
    }

    Integer getMatchCount(List<Integer> winningNumber) {
        return (int) this.lottoNumbers.stream()
                .map(LottoNum::getLottoNum)
                .filter(winningNumber::contains)
                .count();
    }

    public List<Integer> getWinningNumbersToIntegerList() {
        return lottoNumbers.stream()
                .map(LottoNum::getLottoNum)
                .collect(Collectors.toList());
    }
}
