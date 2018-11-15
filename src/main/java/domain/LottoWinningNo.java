package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNo {

    List<LottoNo> winnerNumbers;
    int bonusNumber;

    public LottoWinningNo(List<LottoNo> winnerNumbers, int bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isExistBonusNumber(List<LottoNo> numbers) {
        return isContainSameNumber(numbers, bonusNumber);
    }

    public static boolean isContainSameNumber(List<LottoNo> numbers, int bonusNumber) {
        return numbers.stream()
                .filter(lottoNo -> lottoNo.getNumber() == bonusNumber)
                .count() > 0;
    }

    public int calculateMatchCount(List<LottoNo> numbers) {
        return calculateMatchNumbers(numbers).size();
    }

    public List<LottoNo> calculateMatchNumbers(List<LottoNo> lottoNos) {
        List<LottoNo> matchNumbers = new ArrayList<>();

        for (LottoNo number : lottoNos) {
            if (isContainSameNumber(winnerNumbers, number.getNumber())) {
                matchNumbers.add(number);
            }
        }
        return matchNumbers;
    }
}
