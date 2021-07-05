package lotto.model;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoNumbers(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자 갯수는 6개여야 합니다.");
        }
    }

    public int countWinningNumbers(Lotto winningLotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (winningLotto.contains(lottoNumber)) {
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
