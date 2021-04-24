package step02.model.lotto;

import step02.model.numberRule.NumberRule;
import step02.utils.Validation;
import step02.dto.LottoNumbersDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static step02.utils.LottoConfig.*;

public class LottoNumbers {

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public LottoNumbers(NumberRule numberRule)  {
        makeNumbers(numberRule);
    }

    private void makeNumbers(NumberRule numberRule) {
        Validation.numberCount(numberRule.makeNumbers().size());
        for (int numbers : numberRule.makeNumbers()) {
            lottoNumbers.add(new LottoNumber(numbers));
        }
    }

    public int countCompareMatchNumber(LottoNumbers winnerNumbers) {
        int countMatch = ZERO;
        for (LottoNumber winnerNumber : winnerNumbers.lottoNumbers) {
            countMatch += matchingCount(winnerNumber);
        }
        return countMatch;
    }

    public boolean compareMatchBonusNumber(LottoNumber bonusNumber) {
        return matchingCount(bonusNumber) == ONE;
    }

    public boolean duplicateNumber(LottoNumber bonusNumber) {
       return lottoNumbers.stream().anyMatch(number -> number.equals(bonusNumber));
    }

    private int matchingCount(LottoNumber winnerNumber) {
        if (lottoNumbers.contains(winnerNumber)) {
            return ONE;
        }
        return ZERO;
    }

    public LottoNumbersDTO getLottoNumbersResult() {
        return new LottoNumbersDTO(new ArrayList(lottoNumbers));
    }
}
