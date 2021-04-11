package step02;

import java.util.HashSet;
import java.util.Set;

import static step02.LottoConfig.*;

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
            countMatch += mathingCount(winnerNumber);
        }
        return countMatch;
    }

    private int mathingCount(LottoNumber winnerNumber) {
        if (lottoNumbers.contains(winnerNumber)) {
            return ONE;
        }
        return ZERO;
    }

    public LottoNumbersDTO getLottoNumbersResult() {
        LottoNumbersDTO lottoDTO = new LottoNumbersDTO();
        lottoDTO.setLottoNumbers(lottoNumbers);
        return lottoDTO;
    }
}
