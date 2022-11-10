package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public int countWinner(List<String> winningNumber) {
        return (int) lotto.stream()
                .flatMap(lottoNumber -> winningNumber.stream()
                        .filter(lottoNumber::isWinningNumber))
                .count();
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
