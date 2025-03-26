package domain.lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        if (!validateLottoNumbers(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    private boolean validateLottoNumbers(List<Integer> lottoNumbers) {
        return validateNumbersSize(lottoNumbers) && validateNumbersInBoundary(lottoNumbers)
                && validateUniqueNumbers(lottoNumbers);
    }

    private boolean validateNumbersSize(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == 6;
    }

    private boolean validateUniqueNumbers(List<Integer> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size() != 6;
    }

    private boolean validateNumbersInBoundary(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                return true;
            }
        }
        return false;
    }
}
