package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LottoWinningNo {

    private List<LottoNo> winnerNumbers;
    private LottoNo bonusNumber;

    public LottoWinningNo(List<LottoNo> winnerNumbers, LottoNo bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isExistBonusNumber(List<LottoNo> numbers) {
        return isContainSameNumber(numbers, bonusNumber);
    }

    public static boolean isContainSameNumber(List<LottoNo> numbers, LottoNo bonusNumber) {
        return numbers.stream()
                .filter(lottoNo -> lottoNo.isExistBonusNumber(bonusNumber))
                .count() > 0;
    }

    public int calculateMatchCount(List<LottoNo> numbers) {
        return calculateMatchNumbers(numbers).size();
    }

    public List<LottoNo> calculateMatchNumbers(List<LottoNo> lottoNos) {
        List<LottoNo> matchNumbers = new ArrayList<>();

        for (LottoNo number : lottoNos) {
            if (isContainSameNumber(winnerNumbers, number)) {
                matchNumbers.add(number);
            }
        }
        return matchNumbers;
    }

}
