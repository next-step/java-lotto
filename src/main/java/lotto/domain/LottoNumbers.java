package lotto.domain;

import lotto.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public static final int RANK_SUB_NUMBER = 7;
    public static final int DEFAULT_NUMBER = 0;
    public static final int MINIMUM_MATCHING_NUMBER = 3;
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<Integer> lottoWinningList) {
        for (int winningNumber : lottoWinningList) {
            lottoNumbers.add(new LottoNumber(winningNumber));
        }
        checkSize();
    }

    private void checkSize() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int lottoRank(List<LottoNumber> lottoNumbers) {
        int matchingCount = getMatchingCount(lottoNumbers);
        return LottoRank.convertMatchingCountToRank(matchingCount);
    }

    private int getMatchingCount(List<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    protected List<Integer> convertIntLottoNumbersList() {
        List<Integer> totalLottoNumbersList = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            totalLottoNumbersList.add(lottoNumber.getLottoNumber());
        }
        return totalLottoNumbersList;
    }

    protected List<LottoNumber> getLottoNumberList() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }


}
