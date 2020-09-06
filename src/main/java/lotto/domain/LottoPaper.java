package lotto.domain;

import lotto.context.Error;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPaper {
    private static final int MAX_LIST_SIZE = 6;
    private static final String TEXT_SPLIT_DIVISION = ",";

    private final List<LottoNum> lottoNumbers;

    public LottoPaper(List<LottoNum> numberList) {
        validLottoPaper(numberList);
        lottoNumbers = numberList;
    }

    public LottoPaper(String textNumber) {
        lottoNumbers = Arrays.stream(textNumber.split(TEXT_SPLIT_DIVISION))
                .map(String::trim)
                .map(s -> LottoNum.of(s))
                .collect(Collectors.toList());
    }

    private void validLottoPaper(List<LottoNum> numberList) {
        if (numberList.size() > MAX_LIST_SIZE || isReduplication(numberList)) {
            throw new IllegalArgumentException(Error.ERROR_MAX_LIST_LOTTO_PAPER.getMsg());
        }
    }

    private int getDistinctCount(List<LottoNum> numberList) {
        return (int) numberList.stream()
                .map(LottoNum::getLottoNum)
                .distinct()
                .count();
    }

    private boolean isReduplication(List<LottoNum> numberList) {
        return getDistinctCount(numberList) != numberList.size();
    }

    public List<LottoNum> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    Integer getMatchCount(List<Integer> lottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .map(LottoNum::getLottoNum)
                .filter(lottoNumbers::contains)
                .count();
    }

    public boolean isContain(LottoNum bonusBall) {
        return lottoNumbers.contains(bonusBall);
    }

    public List<Integer> getLottoNumberToIntegerList() {
        return lottoNumbers.stream()
                .map(LottoNum::getLottoNum)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(LottoNum::getLottoNum)
                .collect(Collectors.toList()).toString();
    }
}
