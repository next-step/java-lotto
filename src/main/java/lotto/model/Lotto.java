package lotto.model;

import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countWinningNumbers(Lotto winningNumbers) {
        int count = 0;
        for(LottoNumber winningNumber : winningNumbers.getNumbers()) {
            if(lottoNumbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(LottoNumber number) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (lottoNumber.isSame(number)) {
                return true;
            }
        }
        return false;
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
