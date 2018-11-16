package domain;

import java.util.ArrayList;
import java.util.List;

import static util.Validation.validateBonusNo;
import static util.Validation.validateLottoNos;

public class LottoWinning {

    private List<LottoNo> winnerNumbers;
    private LottoNo bonusNumber;

    private LottoWinning(List<LottoNo> winnerNumbers, LottoNo bonusNumber) {
        validateLottoNos(winnerNumbers);
        this.winnerNumbers = winnerNumbers;
        validateBonusNo(winnerNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinning from(List<LottoNo> winnerNumbers, LottoNo bonusNumber) {
        return new LottoWinning(winnerNumbers,bonusNumber);
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
