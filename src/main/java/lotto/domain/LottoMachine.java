package lotto.domain;

import java.util.List;

public class LottoMachine {
    public Lotto generateLotto(List<Integer> numberList) {
        Lotto lotto = new Lotto(numberList);
        return lotto;
    }
}
