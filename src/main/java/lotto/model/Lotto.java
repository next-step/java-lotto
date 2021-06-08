package lotto.model;

import java.util.List;

public class Lotto {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countWinningNumbers(Lotto winningNumbers) {
        int count = 0;
        for (int i = 0; i < NUMBER_OF_LOTTO_NUMBERS; i++) {
            if (lottoNumbers.contains(winningNumbers.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(LottoNumber number) {
        for(LottoNumber lottoNumber : lottoNumbers) {
            if(lottoNumber.getNumber() == number.getNumber()) {
                return true;
            }
        }
        return false;
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
