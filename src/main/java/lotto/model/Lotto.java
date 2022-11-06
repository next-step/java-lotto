package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public int findWinner(List<String> winningNumber) {
        int matchingCount = 0;

        for (LottoNumber lottoNum : lotto) {
            matchingCount = counting(matchingCount, lottoNum, winningNumber);
        }

        return matchingCount;
    }

    private int counting(int matchingCount, LottoNumber lottoNum, List<String> winningNum) {
        for (String winNums : winningNum) {
            if (lottoNum.isWinningNumber(winNums)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    public static Lotto toLottoNumber(List<Integer> lotto) {
        List<LottoNumber> list = new ArrayList<>();
        for (Integer integer : lotto) {
            list.add(LottoNumber.cache().get(integer));
        }
        return new Lotto(list);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }
}
