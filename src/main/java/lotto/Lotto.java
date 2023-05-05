package lotto;

import java.util.List;

public class Lotto {

    List<Integer> lotto;

    Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    int countEqualNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer lottoNumber : lotto) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

}
