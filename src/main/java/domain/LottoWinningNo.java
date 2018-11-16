package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static util.CollectionCast.changeListToMap;
import static util.Validation.validateBonusNo;
import static util.Validation.validateLottoNos;

public class LottoWinningNo {

    private Map<Integer, LottoNo> winnerNumbers;
    private LottoNo bonusNumber;

    public LottoWinningNo(List<LottoNo> winnerNumbers, LottoNo bonusNumber) {
        validateLottoNos(winnerNumbers);
        this.winnerNumbers = changeListToMap(winnerNumbers);
        validateBonusNo(winnerNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean isExistBonusNumber(Map<Integer, LottoNo> numbers) {
        return isContainSameNumber(numbers, bonusNumber);
    }

    public static boolean isContainSameNumber(Map<Integer, LottoNo> numbers, LottoNo bonusNumber) {
        return numbers.entrySet().stream()
                .filter(number -> number.getValue().isExistBonusNumber(bonusNumber))
                .count() > 0;
    }

    public int calculateMatchCount(Map<Integer, LottoNo> numbers) {
        return calculateMatchNumbers(numbers).size();
    }

    public List<LottoNo> calculateMatchNumbers(Map<Integer, LottoNo> lottoNos) {
        List<LottoNo> matchNumbers = new ArrayList<>();

        for (LottoNo number : lottoNos.values()) {
            if (isContainSameNumber(winnerNumbers, number)) {
                matchNumbers.add(number);
            }
        }
        return matchNumbers;
    }

}
