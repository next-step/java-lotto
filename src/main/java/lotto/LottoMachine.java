package lotto;

import java.util.List;

public class LottoMachine {

    public int matchLottoNumber(List<Integer> winLotto, List<Integer> generatedLotto) {
        int sum = 0;

        for (Integer lottoNumber : winLotto) {
            sum += increaseCountIfMatched(lottoNumber, generatedLotto);
        }

        return sum;
    }

    private int increaseCountIfMatched(Integer lottoNumber, List<Integer> generatedLotto) {
        if (generatedLotto.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
