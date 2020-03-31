package lotto.domain;

import lotto.exception.OutOfLottoNumberSizeException;

import java.util.*;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_MAX_SIZE = 6;
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(final String input) {
        this(newInstanceFromInput(input));
    }

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        checkLottoNumberSize(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private static List<LottoNumber> newInstanceFromInput(final String input) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String letter : input.split(LOTTO_NUMBER_DELIMITER)) {
            LottoNumber lottoNumber = LottoNumber.valueOf(Integer.valueOf(letter));
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private void checkLottoNumberSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers != null && lottoNumbers.size() != LOTTO_NUMBER_MAX_SIZE) {
            throw new OutOfLottoNumberSizeException();
        }
    }
    
    private List<LottoNumber> deepCopy() {
        List<LottoNumber> clone = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            clone.add(LottoNumber.clone(lottoNumber));
        }
        return clone;
    }

    LottoRank analyzeRank(final LottoNumbers winningLotteNumbers, final LottoNumber bonusBall) {
        int matchCount = analyzeMatchCount(winningLotteNumbers);
        boolean hasBonusBall = this.hasBonusBall(bonusBall);
        return LottoRank.findRank(matchCount, hasBonusBall);
    }

    private int analyzeMatchCount(final LottoNumbers winningLotteNumbers) {
        List<LottoNumber> source = this.deepCopy();
        List<LottoNumber> win = winningLotteNumbers.deepCopy();
        source.removeAll(win);
        return LOTTO_NUMBER_MAX_SIZE - source.size();
    }

    boolean hasBonusBall(final LottoNumber bonusBall) {
        return lottoNumbers.contains(bonusBall);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
