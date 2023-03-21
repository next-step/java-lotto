package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WinLottoNumber {

    private LottoNumbers beforeLottoNumber;
    private LottoNumber bonusNumber;

    public WinLottoNumber(LottoNumbers lottoNumber, LottoNumber bonusNumber) {
        this.beforeLottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
        beforeLottoNumber.bonusNumberCheck(bonusNumber);
    }

    public LottoRank matchingLottoNumber(LottoNumbers lottoNumbers) {
        int matchingCount = 0;
        boolean bonusYN = false;

        for (LottoNumber resultNumber : lottoNumbers.getLottoNumber()) {
            matchingCount += getMatchingLottoCount(resultNumber);
        }

        if (matchingCount == 5) {
            bonusYN = getMatchingBonus(lottoNumbers.getLottoNumber());
        }

        return LottoRank.getLottoRank(matchingCount, bonusYN);
    }

    private int getMatchingLottoCount(LottoNumber lottoNumber) {
        int result = 0;
        for (LottoNumber number : beforeLottoNumber.getLottoNumber()) {
            if (lottoNumber.getNumber() == number.getNumber()) {
                result++;
            }
        }
        return result;
    }

    private Boolean getMatchingBonus(Set<LottoNumber> lottoNumberSet) {
        for (LottoNumber number : lottoNumberSet) {
            if (number.getNumber() == bonusNumber.getNumber()) {
                return true;
            }
        }
        return false;
    }
}
