package lotto.domain;

import lotto.context.Error;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPaper {
    private static final int MAX_LIST_SIZE = 6;

    private final List<LottoNum> lottoNumbers;

    public LottoPaper(List<LottoNum> numberList) {
        validLottoPaper(numberList);
        lottoNumbers = numberList;
    }

    private void validLottoPaper(List<LottoNum> numberList) {
        if (numberList.size() > MAX_LIST_SIZE) {
            throw new IllegalArgumentException(Error.ERROR_MAX_LIST_LOTTO_PAPER.getMsg());
        }
        if (numberList.stream()
                .map(LottoNum::getLottoNum)
                .distinct()
                .count() != numberList.size()) {
            throw new IllegalArgumentException(Error.ERROR_REDUPLICATION_LOTTO_PAPER.getMsg());
        }
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
