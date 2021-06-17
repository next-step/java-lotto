package lotto.model;

import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoNumbers(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자 갯수는 6개여야 합니다.");
        }
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
