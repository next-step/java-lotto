package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    List<LottoNumber> lotto;


    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        this.lotto = lotto;
    }

    int countEqualNumbers(Lotto winningNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            if (winningNumbers.contain(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean contain(LottoNumber otherLottoNumber) {
        for (LottoNumber lottoNumber : lotto) {
            if (lottoNumber.equals(otherLottoNumber)) {
                return true;
            }
        }
        return false;
    }

}
