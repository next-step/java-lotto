package lotto.model;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLottoSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자 갯수는 6개여야 합니다.");
        }
    }

    public void checkLottoNumbers() {
        boolean accordance = false;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            for (int j = 0; j < i; j++) {
                if (lottoNumbers.get(i) == lottoNumbers.get(j)) {
                    accordance = true;
                }
            }
        }
        if (accordance) {
            throw new IllegalArgumentException("로또 번호는 모두 달라야 합니다.");
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
